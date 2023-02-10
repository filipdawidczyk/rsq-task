package com.example.rsqtask.application.port.out.patient

import com.example.rsqtask.domain.Patient
import com.example.rsqtask.domain.Patients

interface FetchPatientsPort {
    fun fetch(uuid: String): Patient?
    fun fetchAll(): Patients
}