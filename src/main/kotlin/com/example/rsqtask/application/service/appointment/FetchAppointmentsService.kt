package com.example.rsqtask.application.service.appointment

import com.example.rsqtask.application.port.`in`.appointment.FetchAppointmentsUseCase
import com.example.rsqtask.application.port.`in`.appointment.FetchPatientAppointmentsUseCase
import com.example.rsqtask.application.port.out.appointment.FetchAppointmentsPort
import com.example.rsqtask.domain.Appointments
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
internal class FetchAppointmentsService(
    private val fetchAppointmentsPort: FetchAppointmentsPort
) : FetchAppointmentsUseCase, FetchPatientAppointmentsUseCase {

    override fun fetch(): Appointments {
        logger.info { "Fetching all system appointments" }
        val result = fetchAppointmentsPort.fetchAll()
        logger.info { "Found ${result.appointments.size} appointments" }
        return result.sortedByDateTimeAscending()
    }

    override fun fetch(patientUuid: String): Appointments {
        logger.info { "Fetching all patient's (uuid: $patientUuid) appointments " }
        val result = fetchAppointmentsPort.fetchByPatient(patientUuid)
        logger.info { "Found ${result.appointments.size} appointments" }
        return result.sortedByDateTimeAscending()
    }
}