package com.example.rsqtask.adapter.out.patient

import com.example.rsqtask.adapter.out.repository.PatientRepository
import com.example.rsqtask.application.port.out.patient.RemovePatientPort
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

private val logger = KotlinLogging.logger {}

@Component
internal class RemovePatientAdapter(
    private val patientRepository: PatientRepository
) : RemovePatientPort {

    @Transactional
    override fun remove(uuid: String) {
        patientRepository.deleteByUuid(uuid)
        logger.info { "Patient with uuid: $uuid removed" }
    }
}