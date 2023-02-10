package com.example.rsqtask.application.port.out.appointment

import com.example.rsqtask.domain.Appointment
import com.example.rsqtask.domain.Appointments

interface FetchAppointmentsPort {
    fun fetch(uuid: String): Appointment?
    fun fetchAll(): Appointments
    fun fetchByPatient(patientUuid: String): Appointments
    fun fetchByDoctor(doctorUuid: String): Appointments
}