package com.example.rsqtask.adapter.`in`.web

import com.example.rsqtask.application.port.`in`.doctor.*
import com.example.rsqtask.application.port.`in`.patient.*
import com.example.rsqtask.application.port.`in`.patient.request.PatientRequest
import com.example.rsqtask.domain.Patient
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/patients")
internal class PatientResource(
    private val fetchAllPatientsUseCase: FetchAllPatientsUseCase,
    private val fetchPatientUseCase: FetchPatientUseCase,
    private val addPatientUseCase: AddPatientUseCase,
    private val modifyPatientUseCase: ModifyPatientUseCase,
    private val removePatientUseCase: RemovePatientUseCase
) {

    @GetMapping
    fun getAll() = fetchAllPatientsUseCase.fetchAll()

    @GetMapping("/{uuid}")
    fun get(@PathVariable("uuid") uuid: String) = fetchPatientUseCase.fetch(uuid)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@RequestBody request: PatientRequest): Patient = addPatientUseCase.add(request)

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{uuid}")
    fun modify(@PathVariable("uuid") uuid: String, @RequestBody request: PatientRequest): Patient =
        modifyPatientUseCase.modify(uuid, request)

    @DeleteMapping("/{uuid}")
    fun remove(@PathVariable("uuid") uuid: String) {
        removePatientUseCase.remove(uuid)
    }

}