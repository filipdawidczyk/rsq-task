package com.example.rsqtask.application.service.appointment

import com.example.rsqtask.application.port.`in`.appointment.CreateAppointmentRequest
import com.example.rsqtask.application.port.`in`.appointment.MakeAppointmentUseCase
import com.example.rsqtask.application.port.out.appointment.SaveAppointmentPort
import com.example.rsqtask.application.port.out.doctor.FetchDoctorsPort
import com.example.rsqtask.application.port.out.patient.FetchPatientsPort
import com.example.rsqtask.application.service.exceptions.DateInThePastException
import com.example.rsqtask.application.service.exceptions.NotFoundException
import com.example.rsqtask.domain.Appointment
import com.example.rsqtask.domain.Place
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.time.Clock
import java.time.LocalDateTime.now
import java.time.temporal.ChronoUnit.MINUTES
import java.util.*

private val logger = KotlinLogging.logger {}

/**
 * (TODO)
 * Missing validations:
 * - check if requested doctor have not any other appointment at the same time
 * - check if requested patient have not any other appointment at the same time
 */
@Service
internal class MakeAppointmentService(
    private val defaultClock: Clock,
    private val fetchDoctorsPort: FetchDoctorsPort,
    private val fetchPatientsPort: FetchPatientsPort,
    private val saveAppointmentPort: SaveAppointmentPort,
) : MakeAppointmentUseCase {
    override fun create(request: CreateAppointmentRequest): Appointment {
        logger.info { "Creating new appointment: $request" }

        val doctor = fetchDoctorsPort.fetch(request.doctorUuid)
            ?: throw NotFoundException("Doctor with uuid: ${request.doctorUuid} not found")
        val patient = fetchPatientsPort.fetch(request.patientUuid)
            ?: throw NotFoundException("Patient with uuid: ${request.patientUuid} not found")

        val requestedAppointmentDateTime = request.datetime.truncatedTo(MINUTES)

        if (requestedAppointmentDateTime.isBefore(now(defaultClock))) {
            throw DateInThePastException("Appointment time cannot be in the past")
        }

        return saveAppointmentPort.create(
            Appointment(
                uuid = UUID.randomUUID(),
                datetime = requestedAppointmentDateTime,
                place = Place(
                    name = request.place.name,
                    street = request.place.street,
                    zipCode = request.place.zipCode,
                    city = request.place.city
                ),
                doctor = doctor,
                patient = patient
            )
        )
    }
}