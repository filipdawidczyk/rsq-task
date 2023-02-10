package com.example.rsqtask.adapter.out.doctor

import com.example.rsqtask.adapter.out.repository.DoctorRepository
import com.example.rsqtask.application.port.out.doctor.CheckDoctorExistencePort
import org.springframework.stereotype.Component

@Component
internal class CheckDoctorExistenceAdapter(
    private val doctorRepository: DoctorRepository
) : CheckDoctorExistencePort {
    override fun exist(uuid: String): Boolean = doctorRepository.existsByUuid(uuid)
}