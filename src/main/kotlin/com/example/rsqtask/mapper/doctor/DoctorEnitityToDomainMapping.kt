package com.example.rsqtask.mapper.doctor

import com.example.rsqtask.adapter.out.repository.DoctorEntity
import com.example.rsqtask.domain.Doctor
import java.util.*

internal fun DoctorEntity.toDomain() = Doctor(
    uuid = UUID.fromString(uuid),
    firstname = firstname!!,
    lastname = lastname!!,
    specialization = specialization!!.toDomain()
)

internal fun DoctorEntity.Specialization.toDomain() = when (this) {
    DoctorEntity.Specialization.ALLERGY_AND_IMMUNOLOGY -> Doctor.Specialization.ALLERGY_AND_IMMUNOLOGY
    DoctorEntity.Specialization.ANESTHESIOLOGY -> Doctor.Specialization.ANESTHESIOLOGY
    DoctorEntity.Specialization.CARDIOLOGY -> Doctor.Specialization.CARDIOLOGY
    DoctorEntity.Specialization.DERMATOLOGY -> Doctor.Specialization.DERMATOLOGY
    DoctorEntity.Specialization.DIABETES_AND_ENDOCRINOLOGY -> Doctor.Specialization.DIABETES_AND_ENDOCRINOLOGY
    DoctorEntity.Specialization.EMERGENCY_MEDICINE -> Doctor.Specialization.EMERGENCY_MEDICINE
    DoctorEntity.Specialization.GASTROENTEROLOGY -> Doctor.Specialization.GASTROENTEROLOGY
    DoctorEntity.Specialization.GERIATRICS -> Doctor.Specialization.GERIATRICS
    DoctorEntity.Specialization.GYNECOLOGY -> Doctor.Specialization.GYNECOLOGY
    DoctorEntity.Specialization.HEMATOLOGY -> Doctor.Specialization.HEMATOLOGY
    DoctorEntity.Specialization.INFECTIOUS_DISEASE -> Doctor.Specialization.INFECTIOUS_DISEASE
    DoctorEntity.Specialization.INTERNAL_MEDICINE -> Doctor.Specialization.INTERNAL_MEDICINE
    DoctorEntity.Specialization.NEPHROLOGY -> Doctor.Specialization.NEPHROLOGY
    DoctorEntity.Specialization.NEUROLOGY -> Doctor.Specialization.NEUROLOGY
    DoctorEntity.Specialization.OBSTETRICS_AND_GYNECOLOGY -> Doctor.Specialization.OBSTETRICS_AND_GYNECOLOGY
    DoctorEntity.Specialization.ONCOLOGY -> Doctor.Specialization.ONCOLOGY
    DoctorEntity.Specialization.OPHTHALMOLOGY -> Doctor.Specialization.OPHTHALMOLOGY
    DoctorEntity.Specialization.ORTHOPEDICS -> Doctor.Specialization.ORTHOPEDICS
    DoctorEntity.Specialization.OTOLARYNGOLOGY -> Doctor.Specialization.OTOLARYNGOLOGY
    DoctorEntity.Specialization.PEDIATRICS -> Doctor.Specialization.PEDIATRICS
    DoctorEntity.Specialization.PSYCHIATRY -> Doctor.Specialization.PSYCHIATRY
    DoctorEntity.Specialization.PULMONOLOGY -> Doctor.Specialization.PULMONOLOGY
    DoctorEntity.Specialization.RADIOLOGY -> Doctor.Specialization.RADIOLOGY
    DoctorEntity.Specialization.RHEUMATOLOGY -> Doctor.Specialization.RHEUMATOLOGY
    DoctorEntity.Specialization.SURGERY -> Doctor.Specialization.SURGERY
    DoctorEntity.Specialization.UROLOGY -> Doctor.Specialization.UROLOGY
}