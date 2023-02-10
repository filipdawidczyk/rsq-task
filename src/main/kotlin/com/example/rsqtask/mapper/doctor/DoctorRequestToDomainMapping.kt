package com.example.rsqtask.mapper.doctor

import com.example.rsqtask.application.port.`in`.doctor.request.DoctorRequest
import com.example.rsqtask.domain.Doctor

internal fun DoctorRequest.Specialization.toDomain() = when (this) {
    DoctorRequest.Specialization.ALLERGY_AND_IMMUNOLOGY -> Doctor.Specialization.ALLERGY_AND_IMMUNOLOGY
    DoctorRequest.Specialization.ANESTHESIOLOGY -> Doctor.Specialization.ANESTHESIOLOGY
    DoctorRequest.Specialization.CARDIOLOGY -> Doctor.Specialization.CARDIOLOGY
    DoctorRequest.Specialization.DERMATOLOGY -> Doctor.Specialization.DERMATOLOGY
    DoctorRequest.Specialization.DIABETES_AND_ENDOCRINOLOGY -> Doctor.Specialization.DIABETES_AND_ENDOCRINOLOGY
    DoctorRequest.Specialization.EMERGENCY_MEDICINE -> Doctor.Specialization.EMERGENCY_MEDICINE
    DoctorRequest.Specialization.GASTROENTEROLOGY -> Doctor.Specialization.GASTROENTEROLOGY
    DoctorRequest.Specialization.GERIATRICS -> Doctor.Specialization.GERIATRICS
    DoctorRequest.Specialization.GYNECOLOGY -> Doctor.Specialization.GYNECOLOGY
    DoctorRequest.Specialization.HEMATOLOGY -> Doctor.Specialization.HEMATOLOGY
    DoctorRequest.Specialization.INFECTIOUS_DISEASE -> Doctor.Specialization.INFECTIOUS_DISEASE
    DoctorRequest.Specialization.INTERNAL_MEDICINE -> Doctor.Specialization.INTERNAL_MEDICINE
    DoctorRequest.Specialization.NEPHROLOGY -> Doctor.Specialization.NEPHROLOGY
    DoctorRequest.Specialization.NEUROLOGY -> Doctor.Specialization.NEUROLOGY
    DoctorRequest.Specialization.OBSTETRICS_AND_GYNECOLOGY -> Doctor.Specialization.OBSTETRICS_AND_GYNECOLOGY
    DoctorRequest.Specialization.ONCOLOGY -> Doctor.Specialization.ONCOLOGY
    DoctorRequest.Specialization.OPHTHALMOLOGY -> Doctor.Specialization.OPHTHALMOLOGY
    DoctorRequest.Specialization.ORTHOPEDICS -> Doctor.Specialization.ORTHOPEDICS
    DoctorRequest.Specialization.OTOLARYNGOLOGY -> Doctor.Specialization.OTOLARYNGOLOGY
    DoctorRequest.Specialization.PEDIATRICS -> Doctor.Specialization.PEDIATRICS
    DoctorRequest.Specialization.PSYCHIATRY -> Doctor.Specialization.PSYCHIATRY
    DoctorRequest.Specialization.PULMONOLOGY -> Doctor.Specialization.PULMONOLOGY
    DoctorRequest.Specialization.RADIOLOGY -> Doctor.Specialization.RADIOLOGY
    DoctorRequest.Specialization.RHEUMATOLOGY -> Doctor.Specialization.RHEUMATOLOGY
    DoctorRequest.Specialization.SURGERY -> Doctor.Specialization.SURGERY
    DoctorRequest.Specialization.UROLOGY -> Doctor.Specialization.UROLOGY
}