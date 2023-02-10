package com.example.rsqtask.domain

import java.time.LocalDateTime
import java.util.*

data class Appointment(
    val uuid: UUID,
    val datetime: LocalDateTime,
    val place: Place,
    val doctor: Doctor,
    val patient: Patient
) {

    fun rescheduleTime(datetime: LocalDateTime): Appointment = copy(
        datetime = datetime
    )

}