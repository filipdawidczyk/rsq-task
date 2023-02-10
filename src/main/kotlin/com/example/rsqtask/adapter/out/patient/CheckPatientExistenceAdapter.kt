package com.example.rsqtask.adapter.out.patient

import com.example.rsqtask.adapter.out.repository.PatientRepository
import com.example.rsqtask.application.port.out.patient.CheckPatientExistencePort
import org.springframework.stereotype.Component

@Component
internal class CheckPatientExistenceAdapter(
    private val patientRepository: PatientRepository
) : CheckPatientExistencePort {
    override fun exist(uuid: String): Boolean = patientRepository.existsByUuid(uuid)
}