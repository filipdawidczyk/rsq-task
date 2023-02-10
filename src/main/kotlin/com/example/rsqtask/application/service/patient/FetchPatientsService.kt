package com.example.rsqtask.application.service.patient

import com.example.rsqtask.application.port.`in`.patient.FetchAllPatientsUseCase
import com.example.rsqtask.application.port.`in`.patient.FetchPatientUseCase
import com.example.rsqtask.application.port.out.patient.FetchPatientsPort
import com.example.rsqtask.application.service.exceptions.NotFoundException
import com.example.rsqtask.domain.Patient
import com.example.rsqtask.domain.Patients
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
internal class FetchPatientsService(
    private val fetchPatientsPort: FetchPatientsPort
) : FetchAllPatientsUseCase, FetchPatientUseCase {

    override fun fetch(uuid: String): Patient? {
        logger.info { "Fetching patient with uuid: $uuid" }
        return fetchPatientsPort.fetch(uuid)
            ?: throw NotFoundException("Patient with uuid: $uuid does not exist")
    }

    override fun fetchAll(): Patients {
        logger.info { "Fetching all patients" }
        val result = fetchPatientsPort.fetchAll()
        logger.info { "Returned ${result.patients.size} results" }
        return result
    }
}