package com.example.rsqtask.application.service.appointment

import com.example.rsqtask.application.port.`in`.appointment.RemoveAppointmentUseCase
import com.example.rsqtask.application.port.out.appointment.CheckAppointmentExistencePort
import com.example.rsqtask.application.port.out.appointment.RemoveAppointmentPort
import com.example.rsqtask.application.service.exceptions.NotFoundException
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
internal class RemoveAppointmentService(
    private val checkAppointmentExistencePort: CheckAppointmentExistencePort,
    private val removeAppointmentPort: RemoveAppointmentPort
) : RemoveAppointmentUseCase {
    override fun remove(uuid: String) {
        val exist = checkAppointmentExistencePort.exist(uuid)
        if (exist) {
            logger.info { "Removing appointment data with uuid: $uuid" }
            removeAppointmentPort.remove(uuid)
        } else {
            throw NotFoundException("Appointment with uuid: $uuid does not exist")
        }
    }
}