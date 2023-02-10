package com.example.rsqtask.application.port.`in`.doctor

import com.example.rsqtask.domain.Doctors

interface FetchAllDoctorsUseCase {
    fun fetchAll(): Doctors
}