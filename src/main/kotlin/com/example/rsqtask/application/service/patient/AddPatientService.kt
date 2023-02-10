package com.example.rsqtask.application.service.patient

import com.example.rsqtask.application.port.`in`.patient.AddPatientUseCase
import com.example.rsqtask.application.port.`in`.patient.request.PatientRequest
import com.example.rsqtask.application.port.out.patient.SavePatientPort
import com.example.rsqtask.domain.Patient
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.util.*

private val logger = KotlinLogging.logger {}

@Component
internal class AddPatientService(
    private val savePatientPort: SavePatientPort
) : AddPatientUseCase {
    override fun add(request: PatientRequest): Patient {
        logger.info { "Creating new patient: $request" }
        return savePatientPort.save(
            Patient(
                uuid = UUID.randomUUID(),
                firstname = request.firstname,
                lastname = request.lastname,
                street = request.street,
                zipCode = request.zipCode,
                city = request.city
            )
        )
    }
}