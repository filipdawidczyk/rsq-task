package com.example.rsqtask.application.port.out.doctor

import com.example.rsqtask.domain.Doctor

interface ModifyDoctorPort {
    fun update(uuid: String, doctor: Doctor): Doctor?
}