package com.example.rsqtask.adapter.out.patient

import com.example.rsqtask.adapter.out.repository.PatientRepository
import com.example.rsqtask.application.port.out.patient.FetchPatientsPort
import com.example.rsqtask.domain.Patient
import com.example.rsqtask.domain.Patients
import com.example.rsqtask.mapper.patient.toDomain
import org.springframework.stereotype.Component

@Component
internal class FetchPatientsAdapter(
    private val patientRepository: PatientRepository
) : FetchPatientsPort {

    override fun fetch(uuid: String): Patient? = patientRepository.findByUuid(uuid)?.toDomain()

    override fun fetchAll(): Patients = patientRepository.findAll()
        .map { it.toDomain() }
        .let { Patients(it) }
}