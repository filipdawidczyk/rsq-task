package com.example.rsqtask.adapter.out.doctor

import com.example.rsqtask.adapter.out.repository.DoctorRepository
import com.example.rsqtask.application.port.out.doctor.RemoveDoctorPort
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

private val logger = KotlinLogging.logger {}

@Component
internal class RemoveDoctorAdapter(
    private val doctorRepository: DoctorRepository
) : RemoveDoctorPort {

    @Transactional
    override fun remove(uuid: String) {
        doctorRepository.deleteByUuid(uuid)
        logger.info { "Doctor with uuid: $uuid removed" }
    }
}