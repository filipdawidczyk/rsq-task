package com.example.rsqtask.application.port.out.patient

interface CheckIfPatientReferencedWithAnyAppointmentPort {
    fun check(patientUuid: String): Boolean
}