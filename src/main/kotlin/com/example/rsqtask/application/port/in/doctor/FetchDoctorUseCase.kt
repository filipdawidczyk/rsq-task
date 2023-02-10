package com.example.rsqtask.application.port.`in`.doctor

import com.example.rsqtask.domain.Doctor

interface FetchDoctorUseCase {
    fun fetch(uuid: String): Doctor?
}