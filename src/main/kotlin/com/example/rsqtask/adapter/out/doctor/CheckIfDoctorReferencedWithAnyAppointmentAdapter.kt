package com.example.rsqtask.adapter.out.doctor

import com.example.rsqtask.adapter.out.repository.AppointmentRepository
import com.example.rsqtask.application.port.out.doctor.CheckIfDoctorReferencedWithAnyAppointmentPort
import org.springframework.stereotype.Component

@Component
internal class CheckIfDoctorReferencedWithAnyAppointmentAdapter(
    private val appointmentRepository: AppointmentRepository
) : CheckIfDoctorReferencedWithAnyAppointmentPort {
    override fun check(doctorUuid: String): Boolean = appointmentRepository.existsByDoctorUuid(doctorUuid)
}