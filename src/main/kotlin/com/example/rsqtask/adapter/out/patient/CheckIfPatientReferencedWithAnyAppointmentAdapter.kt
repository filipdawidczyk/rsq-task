package com.example.rsqtask.adapter.out.patient

import com.example.rsqtask.adapter.out.repository.AppointmentRepository
import com.example.rsqtask.application.port.out.patient.CheckIfPatientReferencedWithAnyAppointmentPort
import org.springframework.stereotype.Component

@Component
internal class CheckIfPatientReferencedWithAnyAppointmentAdapter(
    private val appointmentRepository: AppointmentRepository
) : CheckIfPatientReferencedWithAnyAppointmentPort {
    override fun check(patientUuid: String): Boolean = appointmentRepository.existsByPatientUuid(patientUuid)
}