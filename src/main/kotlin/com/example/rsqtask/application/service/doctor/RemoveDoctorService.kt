package com.example.rsqtask.application.service.doctor

import com.example.rsqtask.application.port.`in`.doctor.RemoveDoctorUseCase
import com.example.rsqtask.application.port.out.doctor.CheckDoctorExistencePort
import com.example.rsqtask.application.port.out.doctor.CheckIfDoctorReferencedWithAnyAppointmentPort
import com.example.rsqtask.application.port.out.doctor.RemoveDoctorPort
import com.example.rsqtask.application.service.exceptions.DoctorIsReferencedWithAppointmentException
import com.example.rsqtask.application.service.exceptions.NotFoundException
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
internal class RemoveDoctorService(
    private val checkIfDoctorReferencedWithAnyAppointmentPort: CheckIfDoctorReferencedWithAnyAppointmentPort,
    private val checkDoctorExistencePort: CheckDoctorExistencePort,
    private val removeDoctorPort: RemoveDoctorPort
) : RemoveDoctorUseCase {
    override fun remove(uuid: String) {
        val exist = checkDoctorExistencePort.exist(uuid)
        val referencedWith = checkIfDoctorReferencedWithAnyAppointmentPort.check(uuid)

        when {
            referencedWith -> throw DoctorIsReferencedWithAppointmentException(
                "Doctor is still referenced with appointment. Get rid of referenced appointments due safe delete doctor data"
            )

            exist -> {
                logger.info { "Removing doctor data with uuid: $uuid" }
                removeDoctorPort.remove(uuid)
            }

            else -> throw NotFoundException("Doctor with uuid: $uuid does not exist")
        }
    }
}