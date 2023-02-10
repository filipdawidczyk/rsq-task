package com.example.rsqtask.application.service.doctor

import com.example.rsqtask.application.port.`in`.doctor.ModifyDoctorUseCase
import com.example.rsqtask.application.port.`in`.doctor.request.DoctorRequest
import com.example.rsqtask.application.port.out.doctor.ModifyDoctorPort
import com.example.rsqtask.application.service.exceptions.NotFoundException
import com.example.rsqtask.domain.Doctor
import com.example.rsqtask.mapper.doctor.toDomain
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.util.*

private val logger = KotlinLogging.logger {}

@Component
internal class ModifyDoctorService(
    private val modifyDoctorPort: ModifyDoctorPort
) : ModifyDoctorUseCase {

    override fun modify(uuid: String, request: DoctorRequest): Doctor {
        logger.info { "Modifying doctor data with uuid: $uuid , by: $request" }
        return modifyDoctorPort.update(uuid, doctor(uuid, request))
            ?: throw NotFoundException("Doctor with uuid: $uuid does no exist")
    }

    private fun doctor(uuid: String, request: DoctorRequest) = Doctor(
        uuid = UUID.fromString(uuid),
        firstname = request.firstname,
        lastname = request.lastname,
        specialization = request.specialization.toDomain()
    )

}