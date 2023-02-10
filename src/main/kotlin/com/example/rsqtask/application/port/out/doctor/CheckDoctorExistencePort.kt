package com.example.rsqtask.application.port.out.doctor

interface CheckDoctorExistencePort {
    fun exist(uuid: String): Boolean
}