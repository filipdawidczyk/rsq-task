package com.example.rsqtask.application.port.out.doctor

import com.example.rsqtask.domain.Doctor
import com.example.rsqtask.domain.Doctors

interface FetchDoctorsPort {
    fun fetch(uuid: String): Doctor?
    fun fetchAll(): Doctors
}