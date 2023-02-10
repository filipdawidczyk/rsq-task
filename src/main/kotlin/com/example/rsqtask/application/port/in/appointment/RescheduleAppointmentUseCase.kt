package com.example.rsqtask.application.port.`in`.appointment

import com.example.rsqtask.domain.Appointment
import com.fasterxml.jackson.annotation.JsonCreator
import java.time.LocalDateTime

interface RescheduleAppointmentUseCase {
    fun reschedule(uuid: String, request: RescheduleRequest): Appointment
}

data class RescheduleRequest @JsonCreator constructor(
    val dateTime: LocalDateTime
)