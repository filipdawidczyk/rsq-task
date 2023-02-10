package com.example.rsqtask.application.port.out.appointment

import com.example.rsqtask.domain.Appointment

interface SaveAppointmentPort {
    fun create(appointment: Appointment): Appointment
    fun update(appointment: Appointment): Appointment
}