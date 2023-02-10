package com.example.rsqtask.application.port.`in`.doctor

import com.example.rsqtask.application.port.`in`.doctor.request.DoctorRequest
import com.example.rsqtask.domain.Doctor

interface ModifyDoctorUseCase {
    fun modify(uuid: String, request: DoctorRequest): Doctor
}

