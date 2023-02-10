package com.example.rsqtask.application.port.`in`.patient

import com.example.rsqtask.application.port.`in`.patient.request.PatientRequest
import com.example.rsqtask.domain.Patient

interface AddPatientUseCase {
    fun add(request: PatientRequest): Patient
}