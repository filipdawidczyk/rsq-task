package com.example.rsqtask.application.port.`in`.appointment

import com.example.rsqtask.domain.Appointments

interface FetchAppointmentsUseCase {
    fun fetch(): Appointments
}