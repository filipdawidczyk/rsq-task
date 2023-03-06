package com.example.rsqtask.adapter.`in`.web

import com.example.rsqtask.application.port.`in`.appointment.*
import com.example.rsqtask.domain.Appointment
import org.springframework.http.HttpStatus.ACCEPTED
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/appointments")
internal class AppointmentResource(
    private val fetchAppointmentsUseCase: FetchAppointmentsUseCase,
    private val fetchPatientAppointmentsUseCase: FetchPatientAppointmentsUseCase,
    private val makeAppointmentUseCase: MakeAppointmentUseCase,
    private val removeAppointmentUseCase: RemoveAppointmentUseCase,
    private val rescheduleAppointmentUseCase: RescheduleAppointmentUseCase
) {

    @GetMapping
    fun getAll(@RequestParam(required = false, value = "patientUuid") patientUuid: String?, ) =
        patientUuid
            ?.let { fetchPatientAppointmentsUseCase.fetch(patientUuid) }
            ?: fetchAppointmentsUseCase.fetch()

    @PostMapping
    fun create(@RequestBody request: CreateAppointmentRequest): Appointment =
        makeAppointmentUseCase.create(request)

    @ResponseStatus(ACCEPTED)
    @PatchMapping("/{uuid}/reschedule")
    fun reschedule(
        @PathVariable("uuid") uuid: String,
        @RequestBody request: RescheduleRequest
    ): Appointment = rescheduleAppointmentUseCase.reschedule(uuid, request)

    @DeleteMapping("/{uuid}")
    fun remove(@PathVariable("uuid") uuid: String) {
        removeAppointmentUseCase.remove(uuid)
    }

    @PutMapping("/{uuid}")
    fun hwdp(@PathVariable("uuid") uuid: String) {
        removeAppointmentUseCase.remove(uuid)
    }
}