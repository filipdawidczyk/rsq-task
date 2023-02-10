package com.example.rsqtask.application.port.`in`.patient.request

data class PatientRequest(
    val firstname: String,
    val lastname: String,
    val street: String,
    val zipCode: String,
    val city: String
)