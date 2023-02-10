package com.example.rsqtask.adapter.`in`.web

import com.example.rsqtask.application.port.`in`.doctor.*
import com.example.rsqtask.application.port.`in`.doctor.request.DoctorRequest
import com.example.rsqtask.domain.Doctor
import org.springframework.http.HttpStatus.ACCEPTED
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/doctors")
internal class DoctorResource(
    private val fetchAllDoctorsUseCase: FetchAllDoctorsUseCase,
    private val fetchDoctorUseCase: FetchDoctorUseCase,
    private val addDoctorUseCase: AddDoctorUseCase,
    private val modifyDoctorUseCase: ModifyDoctorUseCase,
    private val removeDoctorUseCase: RemoveDoctorUseCase
) {

    @GetMapping
    fun getAll() = fetchAllDoctorsUseCase.fetchAll()

    @GetMapping("/{uuid}")
    fun get(@PathVariable("uuid") uuid: String) = fetchDoctorUseCase.fetch(uuid)

    @ResponseStatus(CREATED)
    @PostMapping
    fun create(@RequestBody request: DoctorRequest): Doctor = addDoctorUseCase.add(request)

    @ResponseStatus(ACCEPTED)
    @PutMapping("/{uuid}")
    fun modify(@PathVariable("uuid") uuid: String, @RequestBody request: DoctorRequest): Doctor =
        modifyDoctorUseCase.modify(uuid, request)

    @DeleteMapping("/{uuid}")
    fun remove(@PathVariable("uuid") uuid: String) {
        removeDoctorUseCase.remove(uuid)
    }

}