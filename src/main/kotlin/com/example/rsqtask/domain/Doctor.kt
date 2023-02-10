package com.example.rsqtask.domain

import java.util.*

data class Doctor(
    val uuid: UUID,
    val firstname: String,
    val lastname: String,
    val specialization: Specialization
) {

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