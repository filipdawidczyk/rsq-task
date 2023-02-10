package com.example.rsqtask.application.port.out.patient

import com.example.rsqtask.domain.Patient

interface SavePatientPort {
    fun save(patient: Patient): Patient
}