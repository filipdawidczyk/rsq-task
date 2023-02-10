package com.example.rsqtask.application.service.patient

import com.example.rsqtask.application.port.`in`.patient.ModifyPatientUseCase
import com.example.rsqtask.application.port.`in`.patient.request.PatientRequest
import com.example.rsqtask.application.port.out.patient.ModifyPatientPort
import com.example.rsqtask.application.service.exceptions.NotFoundException
import com.example.rsqtask.domain.Patient
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.util.*

private val logger = KotlinLogging.logger {}

@Component
internal class ModifyPatientService(
    private val modifyPatientPort: ModifyPatientPort
) : ModifyPatientUseCase {

    override fun modify(uuid: String, request: PatientRequest): Patient {
        logger.info { "Modifying patient data with uuid: $uuid , by: $request" }
        return modifyPatientPort.update(uuid, patient(uuid, request))
            ?: throw NotFoundException("Patient with uuid: $uuid does no exist")
    }

    private fun patient(uuid: String, request: PatientRequest) = Patient(
        uuid = UUID.fromString(uuid),
        firstname = request.firstname,
        lastname = request.lastname,
        street = request.street,
        zipCode = request.zipCode,
        city = request.city
    )

}