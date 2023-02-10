package com.example.rsqtask.adapter.out.repository

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository

internal interface PatientRepository : JpaRepository<PatientEntity, Long> {
    fun findByUuid(uuid: String): PatientEntity?
    fun existsByUuid(uuid: String): Boolean
    fun deleteByUuid(uuid: String)
}

@Entity(name = "Patients")
class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    var uuid: String? = null
    var firstname: String? = null
    var lastname: String? = null
    var street: String? = null
    var zipCode: String? = null
    var city: String? = null
}