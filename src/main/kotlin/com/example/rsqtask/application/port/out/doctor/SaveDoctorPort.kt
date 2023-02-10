package com.example.rsqtask.application.port.out.doctor

import com.example.rsqtask.domain.Doctor

interface SaveDoctorPort {
    fun save(doctor: Doctor): Doctor
}