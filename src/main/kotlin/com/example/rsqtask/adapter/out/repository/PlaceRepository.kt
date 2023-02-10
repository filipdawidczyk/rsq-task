package com.example.rsqtask.adapter.out.repository

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.jpa.repository.JpaRepository

internal interface PlaceRepository : JpaRepository<PlaceEntity, Long>

@Entity(name = "Places")
class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    var name: String? = null
    var street: String? = null
    var zipCode: String? = null
    var city: String? = null
}