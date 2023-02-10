package com.example.rsqtask.application.port.`in`.appointment

import com.example.rsqtask.domain.Appointment
import java.time.LocalDateTime

interface MakeAppointmentUseCase {
    fun create(request: CreateAppointmentRequest): Appointment
}

data class CreateAppointmentRequest(
    val datetime: LocalDateTime,
    val place: Place,
    val doctorUuid: String,
    val patientUuid: String
) {
    data class Place(
        val name: String,
        val street: String,
        val zipCode: String,
        val city: String
    )
}