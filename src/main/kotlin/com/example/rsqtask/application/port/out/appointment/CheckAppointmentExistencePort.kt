package com.example.rsqtask.application.port.out.appointment

interface CheckAppointmentExistencePort {
    fun exist(uuid: String): Boolean
}