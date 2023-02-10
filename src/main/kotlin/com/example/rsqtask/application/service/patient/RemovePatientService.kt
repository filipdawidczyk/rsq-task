package com.example.rsqtask.application.service.patient

import com.example.rsqtask.application.port.`in`.patient.RemovePatientUseCase
import com.example.rsqtask.application.port.out.patient.CheckIfPatientReferencedWithAnyAppointmentPort
import com.example.rsqtask.application.port.out.patient.CheckPatientExistencePort
import com.example.rsqtask.application.port.out.patient.RemovePatientPort
import com.example.rsqtask.application.service.exceptions.DoctorIsReferencedWithAppointmentException
import com.example.rsqtask.application.service.exceptions.NotFoundException
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
internal class RemovePatientService(
    private val checkIfPatientReferencedWithAnyAppointmentPort: CheckIfPatientReferencedWithAnyAppointmentPort,
    private val checkPatientExistencePort: CheckPatientExistencePort,
    private val removePatientPort: RemovePatientPort
) : RemovePatientUseCase {
    override fun remove(uuid: String) {
        val exist = checkPatientExistencePort.exist(uuid)
        val referencedWith = checkIfPatientReferencedWithAnyAppointmentPort.check(uuid)

        when {
            referencedWith -> throw DoctorIsReferencedWithAppointmentException(
                "Patient is still referenced with appointment. Get rid of referenced appointments due safe delete doctor data"
            )

            exist -> {
                logger.info { "Removing patient data with uuid: $uuid" }
                removePatientPort.remove(uuid)
            }

            else -> throw NotFoundException("Patient with uuid: $uuid does not exist")
        }

    }
}