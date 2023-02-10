package com.example.rsqtask.adapter.out.repository

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface AppointmentRepository : JpaRepository<AppointmentEntity, Long> {
    fun existsByDoctorUuid(doctorUuid: String): Boolean
    fun existsByPatientUuid(patientUuid: String): Boolean
    fun deleteByUuid(uuid: String)
    fun existsByUuid(uuid: String): Boolean
    fun findAllByPatientUuid(patientUuid: String): List<AppointmentEntity>
    fun findAllByDoctorUuid(doctorUuid: String): List<AppointmentEntity>
    fun findByUuid(uuid: String): AppointmentEntity?
}

@Entity(name = "Appointments")
class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var uuid: String? = null

    var datetime: LocalDateTime? = null

    @OneToOne
    var place: PlaceEntity? = null

    @ManyToOne
    var doctor: DoctorEntity? = null

    @ManyToOne
    var patient: PatientEntity? = null
}
