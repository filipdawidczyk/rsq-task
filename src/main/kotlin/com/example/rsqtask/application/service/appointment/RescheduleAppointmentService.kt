package com.example.rsqtask.application.service.appointment

import com.example.rsqtask.application.port.`in`.appointment.RescheduleAppointmentUseCase
import com.example.rsqtask.application.port.`in`.appointment.RescheduleRequest
import com.example.rsqtask.application.port.out.appointment.FetchAppointmentsPort
import com.example.rsqtask.application.port.out.appointment.ModifyAppointmentPort
import com.example.rsqtask.application.service.exceptions.DateInThePastException
import com.example.rsqtask.application.service.exceptions.DoctorHaveOtherAppointmentAtThisTimeException
import com.example.rsqtask.application.service.exceptions.NotFoundException
import com.example.rsqtask.domain.Appointment
import com.example.rsqtask.domain.Appointments
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.time.Clock
import java.time.LocalDateTime

private val logger = KotlinLogging.logger {}

@Service
internal class RescheduleAppointmentService(
    private val fetchAppointmentsPort: FetchAppointmentsPort,
    private val modifyAppointmentPort: ModifyAppointmentPort,
    private val defaultClock: Clock
) : RescheduleAppointmentUseCase {
    override fun reschedule(uuid: String, request: RescheduleRequest): Appointment {
        logger.info { "Rescheduling appointment with uuid: $uuid" }

        val appointment = fetchAppointmentsPort.fetch(uuid)
            ?: throw NotFoundException("Appointment with uuid: $uuid not found")

        if (request.dateTime.isBefore(LocalDateTime.now(defaultClock))) {
            throw DateInThePastException("Appointment time cannot be in the past")
        }

        if (checkIfDoctorHasAppointmentAtTheSameTime(request.dateTime, doctorOtherAppointments(appointment))) {
            throw DoctorHaveOtherAppointmentAtThisTimeException(
                "Cannot reschedule due doctor's other appointment is already scheduled at this time"
            )
        }

        val rescheduledAppointment = appointment.rescheduleTime(request.dateTime)

        return modifyAppointmentPort.update(rescheduledAppointment)
    }

    private fun doctorOtherAppointments(currentAppointment: Appointment): Appointments = fetchAppointmentsPort
        .fetchByDoctor(currentAppointment.doctor.uuid.toString())
        .appointments
        .filterNot { it.uuid == currentAppointment.uuid }
        .let { Appointments(it) }


    /**
     * TO IMPROVE
     * Validation should check time intervals, not just whether the time is the same
     * (something like 15min time windows or etc. - depends on business requirements)
     */
    private fun checkIfDoctorHasAppointmentAtTheSameTime(
        dateTime: LocalDateTime,
        doctorAppointments: Appointments
    ): Boolean = doctorAppointments.appointments
        .any { it.datetime.isEqual(dateTime) }
}