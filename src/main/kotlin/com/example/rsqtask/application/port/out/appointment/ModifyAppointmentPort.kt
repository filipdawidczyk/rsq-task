package com.example.rsqtask.application.port.out.appointment

import com.example.rsqtask.domain.Appointment

interface ModifyAppointmentPort {
    fun update(appointment: Appointment): Appointment
}