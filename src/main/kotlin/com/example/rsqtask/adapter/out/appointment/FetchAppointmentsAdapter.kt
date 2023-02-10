package com.example.rsqtask.adapter.out.appointment

import com.example.rsqtask.adapter.out.repository.AppointmentRepository
import com.example.rsqtask.application.port.out.appointment.FetchAppointmentsPort
import com.example.rsqtask.domain.Appointment
import com.example.rsqtask.domain.Appointments
import com.example.rsqtask.mapper.appointment.toDomain
import org.springframework.stereotype.Component

@Component
internal class FetchAppointmentsAdapter(
    private val appointmentRepository: AppointmentRepository
) : FetchAppointmentsPort {
    override fun fetch(uuid: String): Appointment? = appointmentRepository.findByUuid(uuid)?.toDomain()

    override fun fetchAll(): Appointments =
        appointmentRepository.findAll()
            .map { it.toDomain() }
            .let { Appointments(it) }

    override fun fetchByPatient(patientUuid: String): Appointments =
        appointmentRepository.findAllByPatientUuid(patientUuid)
            .map { it.toDomain() }
            .let { Appointments(it) }

    override fun fetchByDoctor(doctorUuid: String): Appointments =
        appointmentRepository.findAllByDoctorUuid(doctorUuid)
            .map { it.toDomain() }
            .let { Appointments(it) }
}