package com.example.rsqtask.mapper.patient

import com.example.rsqtask.adapter.out.repository.PatientEntity
import com.example.rsqtask.domain.Patient
import java.util.*

internal fun PatientEntity.toDomain() = Patient(
    uuid = UUID.fromString(uuid),
    firstname = firstname!!,
    lastname = lastname!!,
    street = street!!,
    zipCode = zipCode!!,
    city = city!!
)