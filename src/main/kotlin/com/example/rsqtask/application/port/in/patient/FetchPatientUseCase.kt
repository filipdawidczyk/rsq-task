package com.example.rsqtask.application.port.`in`.patient

import com.example.rsqtask.domain.Patient

interface FetchPatientUseCase {
    fun fetch(uuid: String): Patient?
}