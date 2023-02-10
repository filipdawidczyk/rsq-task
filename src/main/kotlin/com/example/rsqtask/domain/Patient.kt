package com.example.rsqtask.domain

import java.util.*

data class Patient(
    val uuid: UUID,
    val firstname: String,
    val lastname: String,
    val street: String,
    val zipCode: String,
    val city: String
)
