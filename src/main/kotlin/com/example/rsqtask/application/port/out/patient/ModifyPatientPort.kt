package com.example.rsqtask.application.port.out.patient

import com.example.rsqtask.domain.Patient

interface ModifyPatientPort {
    fun update(uuid: String, patient: Patient): Patient?
}