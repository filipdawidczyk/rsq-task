package com.example.rsqtask.application.service.doctor

import com.example.rsqtask.application.port.`in`.doctor.AddDoctorUseCase
import com.example.rsqtask.application.port.`in`.doctor.request.DoctorRequest
import com.example.rsqtask.application.port.out.doctor.SaveDoctorPort
import com.example.rsqtask.domain.Doctor
import com.example.rsqtask.mapper.doctor.toDomain
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.util.*

private val logger = KotlinLogging.logger {}

@Service
internal class AddDoctorService(
    private val saveDoctorPort: SaveDoctorPort
) : AddDoctorUseCase {
    override fun add(request: DoctorRequest): Doctor {
        logger.info { "Creating new doctor: $request" }
        return saveDoctorPort.save(
            Doctor(
                uuid = UUID.randomUUID(),
                firstname = request.firstname,
                lastname = request.lastname,
                specialization = request.specialization.toDomain()
            )
        )
    }
}