package com.example.rsqtask.application.port.`in`.appointment

import com.example.rsqtask.domain.Appointments

interface FetchPatientAppointmentsUseCase {
    fun fetch(patientUuid: String): Appointments
}