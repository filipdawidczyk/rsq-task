package com.example.rsqtask.application.port.out.patient

interface CheckPatientExistencePort {
    fun exist(uuid: String): Boolean
}