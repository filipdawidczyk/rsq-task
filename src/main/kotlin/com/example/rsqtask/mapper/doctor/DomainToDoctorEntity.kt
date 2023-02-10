package com.example.rsqtask.mapper.doctor

import com.example.rsqtask.adapter.out.repository.DoctorEntity
import com.example.rsqtask.domain.Doctor

internal fun Doctor.Specialization.toEntity() = when (this) {
    Doctor.Specialization.ALLERGY_AND_IMMUNOLOGY -> DoctorEntity.Specialization.ALLERGY_AND_IMMUNOLOGY
    Doctor.Specialization.ANESTHESIOLOGY -> DoctorEntity.Specialization.ANESTHESIOLOGY
    Doctor.Specialization.CARDIOLOGY -> DoctorEntity.Specialization.CARDIOLOGY
    Doctor.Specialization.DERMATOLOGY -> DoctorEntity.Specialization.DERMATOLOGY
    Doctor.Specialization.DIABETES_AND_ENDOCRINOLOGY -> DoctorEntity.Specialization.DIABETES_AND_ENDOCRINOLOGY
    Doctor.Specialization.EMERGENCY_MEDICINE -> DoctorEntity.Specialization.EMERGENCY_MEDICINE
    Doctor.Specialization.GASTROENTEROLOGY -> DoctorEntity.Specialization.GASTROENTEROLOGY
    Doctor.Specialization.GERIATRICS -> DoctorEntity.Specialization.GERIATRICS
    Doctor.Specialization.GYNECOLOGY -> DoctorEntity.Specialization.GYNECOLOGY
    Doctor.Specialization.HEMATOLOGY -> DoctorEntity.Specialization.HEMATOLOGY
    Doctor.Specialization.INFECTIOUS_DISEASE -> DoctorEntity.Specialization.INFECTIOUS_DISEASE
    Doctor.Specialization.INTERNAL_MEDICINE -> DoctorEntity.Specialization.INTERNAL_MEDICINE
    Doctor.Specialization.NEPHROLOGY -> DoctorEntity.Specialization.NEPHROLOGY
    Doctor.Specialization.NEUROLOGY -> DoctorEntity.Specialization.NEUROLOGY
    Doctor.Specialization.OBSTETRICS_AND_GYNECOLOGY -> DoctorEntity.Specialization.OBSTETRICS_AND_GYNECOLOGY
    Doctor.Specialization.ONCOLOGY -> DoctorEntity.Specialization.ONCOLOGY
    Doctor.Specialization.OPHTHALMOLOGY -> DoctorEntity.Specialization.OPHTHALMOLOGY
    Doctor.Specialization.ORTHOPEDICS -> DoctorEntity.Specialization.ORTHOPEDICS
    Doctor.Specialization.OTOLARYNGOLOGY -> DoctorEntity.Specialization.OTOLARYNGOLOGY
    Doctor.Specialization.PEDIATRICS -> DoctorEntity.Specialization.PEDIATRICS
    Doctor.Specialization.PSYCHIATRY -> DoctorEntity.Specialization.PSYCHIATRY
    Doctor.Specialization.PULMONOLOGY -> DoctorEntity.Specialization.PULMONOLOGY
    Doctor.Specialization.RADIOLOGY -> DoctorEntity.Specialization.RADIOLOGY
    Doctor.Specialization.RHEUMATOLOGY -> DoctorEntity.Specialization.RHEUMATOLOGY
    Doctor.Specialization.SURGERY -> DoctorEntity.Specialization.SURGERY
    Doctor.Specialization.UROLOGY -> DoctorEntity.Specialization.UROLOGY
}