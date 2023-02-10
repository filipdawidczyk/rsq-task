package com.example.rsqtask.application.service.doctor

import com.example.rsqtask.application.port.`in`.doctor.FetchAllDoctorsUseCase
import com.example.rsqtask.application.port.`in`.doctor.FetchDoctorUseCase
import com.example.rsqtask.application.port.out.doctor.FetchDoctorsPort
import com.example.rsqtask.application.service.exceptions.NotFoundException
import com.example.rsqtask.domain.Doctor
import com.example.rsqtask.domain.Doctors
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
internal class FetchDoctorsService(
    private val fetchDoctorsPort: FetchDoctorsPort
) : FetchAllDoctorsUseCase, FetchDoctorUseCase {

    override fun fetch(uuid: String): Doctor? {
        logger.info { "Fetching doctor with uuid: $uuid" }
        return fetchDoctorsPort.fetch(uuid)
            ?: throw NotFoundException("Doctor with uuid: $uuid does not exist")
    }

    override fun fetchAll(): Doctors {
        logger.info { "Fetching all doctors" }
        val result = fetchDoctorsPort.fetchAll()
        logger.info { "Returned ${result.doctors.size} results" }
        return result
    }
}