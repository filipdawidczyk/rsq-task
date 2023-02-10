package com.example.rsqtask.adapter.out.appointment

import com.example.rsqtask.adapter.out.repository.AppointmentRepository
import com.example.rsqtask.application.port.out.appointment.RemoveAppointmentPort
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

private val logger = KotlinLogging.logger {}

@Component
internal class RemoveAppointmentAdapter(
    private val appointmentRepository: AppointmentRepository
) : RemoveAppointmentPort {

    @Transactional
    override fun remove(uuid: String) {
        appointmentRepository.deleteByUuid(uuid)
        logger.info { "Appointment with uuid: $uuid removed" }
    }

}