package com.example.rsqtask.adapter.out.doctor

import com.example.rsqtask.adapter.out.repository.DoctorEntity
import com.example.rsqtask.adapter.out.repository.DoctorRepository
import com.example.rsqtask.application.port.out.doctor.ModifyDoctorPort
import com.example.rsqtask.application.port.out.doctor.SaveDoctorPort
import com.example.rsqtask.domain.Doctor
import com.example.rsqtask.mapper.doctor.toDomain
import com.example.rsqtask.mapper.doctor.toEntity
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

private val logger = KotlinLogging.logger {}

@Component
internal class SaveDoctorAdapter(
    private val doctorRepository: DoctorRepository
) : SaveDoctorPort, ModifyDoctorPort {

    override fun save(doctor: Doctor): Doctor {
        logger.info { "Saving new doctor data with uuid: ${doctor.uuid}" }
        return doctorRepository.save(
            DoctorEntity().apply {
                this.uuid = doctor.uuid.toString()
                this.firstname = doctor.firstname
                this.lastname = doctor.lastname
                this.specialization = doctor.specialization.toEntity()
            }
        )
            .toDomain()
            .also { logger.info { "Saved" } }
    }

    @Transactional
    override fun update(uuid: String, doctor: Doctor): Doctor? {
        logger.info { "Updating doctor data with uuid: ${doctor.uuid}" }
        return doctorRepository.findByUuid(uuid)?.let {
            doctorRepository.save(
                it.apply {
                    this.firstname = doctor.firstname
                    this.lastname = doctor.lastname
                    this.specialization = doctor.specialization.toEntity()
                }
            )
                .toDomain()
                .also { logger.info { "Updated" } }
        }
    }


}