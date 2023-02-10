package com.example.rsqtask.adapter.out.appointment

import com.example.rsqtask.adapter.out.repository.*
import com.example.rsqtask.application.port.out.appointment.ModifyAppointmentPort
import com.example.rsqtask.application.port.out.appointment.SaveAppointmentPort
import com.example.rsqtask.domain.Appointment
import com.example.rsqtask.domain.Place
import com.example.rsqtask.mapper.appointment.toDomain
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

private val logger = KotlinLogging.logger {}

/**
 * ISSUE
 * Excessive database queries to save relationships. Consider better way to handle it
 */
@Component
internal class SaveAppointmentAdapter(
    private val appointmentRepository: AppointmentRepository,
    private val patientRepository: PatientRepository,
    private val doctorRepository: DoctorRepository,
    private val placeRepository: PlaceRepository
) : SaveAppointmentPort, ModifyAppointmentPort {

    @Transactional
    override fun create(appointment: Appointment): Appointment {
        logger.info { "Saving new appointment with uuid: ${appointment.uuid}" }
        val doctorEntity = doctorRepository.findByUuid(appointment.doctor.uuid.toString())!!
        val patientEntity = patientRepository.findByUuid(appointment.patient.uuid.toString())!!
        val placeEntity = savePlace(appointment.place)

        return appointmentRepository.save(
            AppointmentEntity().apply {
                this.uuid = appointment.uuid.toString()
                this.datetime = appointment.datetime
                this.place = placeEntity
                this.doctor = doctorEntity
                this.patient = patientEntity
            }
        )
            .toDomain()
            .also { logger.info { "Saved" } }
    }

    @Transactional
    override fun update(appointment: Appointment): Appointment {
        logger.info { "Updating appointment data with uuid: ${appointment.uuid}" }

        val originAppointment = appointmentRepository.findByUuid(appointment.uuid.toString())
        val originDoctor = doctorRepository.findByUuid(appointment.doctor.uuid.toString())
        val originPatient = patientRepository.findByUuid(appointment.patient.uuid.toString())
        val originPlace = placeRepository.findById(originAppointment!!.place!!.id!!).get()

        return appointmentRepository.save(
            AppointmentEntity().apply {
                this.id = originAppointment.id
                this.uuid = appointment.uuid.toString()
                this.datetime = appointment.datetime
                this.place = originPlace
                this.doctor = originDoctor
                this.patient = originPatient
            }
        )
            .toDomain()
            .also { logger.info { "Updated" } }
    }

    private fun savePlace(place: Place) = placeRepository.save(
        PlaceEntity().apply {
            this.name = place.name
            this.street = place.street
            this.zipCode = place.zipCode
            this.city = place.city
        }
    )

}