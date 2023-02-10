package com.example.rsqtask.adapter.out.appointment

import com.example.rsqtask.adapter.out.repository.AppointmentRepository
import com.example.rsqtask.application.port.out.appointment.CheckAppointmentExistencePort
import org.springframework.stereotype.Component

@Component
internal class CheckAppointmentExistenceAdapter(
    private val appointmentRepository: AppointmentRepository
) : CheckAppointmentExistencePort {
    override fun exist(uuid: String): Boolean = appointmentRepository.existsByUuid(uuid)
}