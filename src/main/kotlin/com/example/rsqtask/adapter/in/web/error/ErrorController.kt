package com.example.rsqtask.adapter.`in`.web.error

import com.example.rsqtask.adapter.`in`.web.exception.MissingHeaderException
import com.example.rsqtask.application.service.exceptions.*
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
internal class ErrorController {

    /**
     * For debug purpose only
     */
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ErrorResponse {
        return ErrorResponse(ex.message)
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MissingHeaderException::class)
    fun handleMissingHeaderException(ex: MissingHeaderException): ErrorResponse {
        return ErrorResponse(ex.message)
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(DoctorHaveOtherAppointmentAtThisTimeException::class)
    fun handleDoctorHaveOtherAppointmentAtThisTimeException(ex: DoctorHaveOtherAppointmentAtThisTimeException): ErrorResponse {
        return ErrorResponse(ex.message)
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(DateInThePastException::class)
    fun handleDateInThePastException(ex: DateInThePastException): ErrorResponse {
        return ErrorResponse(ex.message)
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(DoctorIsReferencedWithAppointmentException::class)
    fun handleDoctorIsReferencedWithAppointmentException(ex: DoctorIsReferencedWithAppointmentException): ErrorResponse {
        return ErrorResponse(ex.message)
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(PatientIsReferencedWithAppointmentException::class)
    fun handlePatientIsReferencedWithAppointmentException(ex: PatientIsReferencedWithAppointmentException): ErrorResponse {
        return ErrorResponse(ex.message)
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException): ErrorResponse {
        return ErrorResponse(ex.message)
    }

    data class ErrorResponse(
        val message: String? = null
    )
}