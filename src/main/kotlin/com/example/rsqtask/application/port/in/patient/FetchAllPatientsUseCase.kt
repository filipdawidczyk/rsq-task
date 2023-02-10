package com.example.rsqtask.application.port.`in`.patient

import com.example.rsqtask.domain.Patients

interface FetchAllPatientsUseCase {
    fun fetchAll(): Patients
}