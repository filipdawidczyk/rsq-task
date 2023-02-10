package com.example.rsqtask.adapter.out.doctor

import com.example.rsqtask.adapter.out.repository.DoctorRepository
import com.example.rsqtask.application.port.out.doctor.FetchDoctorsPort
import com.example.rsqtask.domain.Doctor
import com.example.rsqtask.domain.Doctors
import com.example.rsqtask.mapper.doctor.toDomain
import org.springframework.stereotype.Component

@Component
internal class FetchDoctorsAdapter(
    private val doctorRepository: DoctorRepository
) : FetchDoctorsPort {

    override fun fetch(uuid: String): Doctor? = doctorRepository.findByUuid(uuid)?.toDomain()

    override fun fetchAll(): Doctors = doctorRepository.findAll()
        .map { it.toDomain() }
        .let { Doctors(it) }

}