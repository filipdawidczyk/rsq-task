package com.example.rsqtask.mapper.appointment

import com.example.rsqtask.adapter.out.repository.AppointmentEntity
import com.example.rsqtask.adapter.out.repository.PlaceEntity
import com.example.rsqtask.domain.Appointment
import com.example.rsqtask.domain.Place
import com.example.rsqtask.mapper.doctor.toDomain
import com.example.rsqtask.mapper.patient.toDomain
import java.util.*

internal fun AppointmentEntity.toDomain() = Appointment(
    uuid = UUID.fromString(uuid),
    datetime = datetime!!,
    place = place!!.toDomain(),
    doctor = doctor!!.toDomain(),
    patient = patient!!.toDomain()
)

internal fun PlaceEntity.toDomain() = Place(
    name = name!!,
    street = street!!,
    zipCode = zipCode!!,
    city = city!!
)