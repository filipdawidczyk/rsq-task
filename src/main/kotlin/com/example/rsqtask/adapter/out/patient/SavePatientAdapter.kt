package com.example.rsqtask.adapter.out.patient

import com.example.rsqtask.adapter.out.repository.PatientEntity
import com.example.rsqtask.adapter.out.repository.PatientRepository
import com.example.rsqtask.application.port.out.patient.ModifyPatientPort
import com.example.rsqtask.application.port.out.patient.SavePatientPort
import com.example.rsqtask.domain.Patient
import com.example.rsqtask.mapper.patient.toDomain
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

private val logger = KotlinLogging.logger {}

@Component
internal class SavePatientAdapter(
    private val patientRepository: PatientRepository
) : SavePatientPort, ModifyPatientPort {

    @Transactional
    override fun save(patient: Patient): Patient {
        logger.info { "Saving new patient data with uuid: ${patient.uuid}" }
        return patientRepository.save(
            PatientEntity().apply {
                this.uuid = patient.uuid.toString()
                this.firstname = patient.firstname
                this.lastname = patient.lastname
                this.street = patient.street
                this.zipCode = patient.zipCode
                this.city = patient.city
            }
        )
            .toDomain()
            .also { logger.info { "Saved" } }
    }

    @Transactional
    override fun update(uuid: String, patient: Patient): Patient? {
        logger.info { "Updating patient data with uuid: ${patient.uuid}" }
        return patientRepository.findByUuid(uuid)?.let {
            patientRepository.save(
                it.apply {
                    this.firstname = patient.firstname
                    this.lastname = patient.lastname
                    this.street = patient.street
                    this.zipCode = patient.zipCode
                    this.city = patient.city
                }
            )
                .toDomain()
                .also { logger.info { "Updated" } }
        }
    }

}