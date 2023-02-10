package com.example.rsqtask.domain

data class Appointments(
    val appointments: List<Appointment>
) {
    fun sortedByDateTimeAscending() = Appointments(appointments.sortedBy { it.datetime })
}
