package com.example.rsqtask.adapter.out.repository

import jakarta.persistence.*
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.GenerationType.IDENTITY
import org.springframework.data.jpa.repository.JpaRepository

internal interface DoctorRepository : JpaRepository<DoctorEntity, Long> {
    fun findByUuid(uuid: String): DoctorEntity?
    fun existsByUuid(uuid: String): Boolean
    fun deleteByUuid(uuid: String)
}

@Entity(name = "Doctors")
class DoctorEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null

    var uuid: String? = null
    var firstname: String? = null
    var lastname: String? = null

    @Enumerated(STRING)
    var specialization: Specialization? = null

    enum class Specialization {
        ALLERGY_AND_IMMUNOLOGY,
        ANESTHESIOLOGY,
        CARDIOLOGY,
        DERMATOLOGY,
        DIABETES_AND_ENDOCRINOLOGY,
        EMERGENCY_MEDICINE,
        GASTROENTEROLOGY,
        GERIATRICS,
        GYNECOLOGY,
        HEMATOLOGY,
        INFECTIOUS_DISEASE,
        INTERNAL_MEDICINE,
        NEPHROLOGY,
        NEUROLOGY,
        OBSTETRICS_AND_GYNECOLOGY,
        ONCOLOGY,
        OPHTHALMOLOGY,
        ORTHOPEDICS,
        OTOLARYNGOLOGY,
        PEDIATRICS,
        PSYCHIATRY,
        PULMONOLOGY,
        RADIOLOGY,
        RHEUMATOLOGY,
        SURGERY,
        UROLOGY
    }
}
