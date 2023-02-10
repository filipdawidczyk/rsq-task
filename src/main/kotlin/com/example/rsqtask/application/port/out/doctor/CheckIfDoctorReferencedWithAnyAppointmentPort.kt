package com.example.rsqtask.application.port.out.doctor

interface CheckIfDoctorReferencedWithAnyAppointmentPort {
    fun check(doctorUuid: String): Boolean
}