package com.example.rsqtask.application.port.`in`.doctor

import com.example.rsqtask.application.port.`in`.doctor.request.DoctorRequest
import com.example.rsqtask.domain.Doctor

interface AddDoctorUseCase {
    fun add(request: DoctorRequest): Doctor
}