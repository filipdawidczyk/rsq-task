package com.example.rsqtask.adapter.out.dummydata

import com.example.rsqtask.adapter.out.repository.*
import com.example.rsqtask.adapter.out.repository.DoctorEntity.Specialization
import mu.KotlinLogging
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.Clock
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit.*
import java.util.*

private val logger = KotlinLogging.logger {}

/**
 * For manual testing purpose only
 */
@Component
private class DummyDataGeneratorOnStartup(
    private val appointmentRepository: AppointmentRepository,
    private val doctorRepository: DoctorRepository,
    private val patientRepository: PatientRepository,
    private val placeRepository: PlaceRepository,
    private val defaultClock: Clock
) {

    @Transactional
    @EventListener(ApplicationReadyEvent::class)
    fun generate() {
        val appointmentPatient1 = savePatient("Filip", "Milanowski", "Wolności 12", "11-700", "Mrągowo")
        val appointmentPatient2 = savePatient("Dawid", "Dawidowski", "Dawidowo 12", "75-142", "Dawidowo")
        val appointmentPatient3 = savePatient("Milena", "Milanowska", "Wolności 12", "56-700", "Lidzbark Waminski")
        savePatient("Mariusz", "Pudzianowski", "Biała Rawska 180", "75-765", "Biała Rawska")
        savePatient("Michaiło", "Podolyak", "Lekarska 87", "83-700", "Gdynia")
        savePatient("Kamil", "Meksykos", "Wolności 12", "11-700", "Mrągowo")
        savePatient("Kamila", "Dawidowska", "Dawidowo 12", "75-142", "Dawidowo")
        savePatient("Yulia", "Potolska", "Trąbki 11", "56-700", "Trąbki")
        savePatient("Henryk", "Biały", "Biała Rawska 280", "75-765", "Biała Rawska")
        savePatient("Andrzej", "Dudda", "Wiejska 123", "02-200", "Warszawa")
        savePatient("Marzena", "Marzońska", "A. Mickewicza 12", "11-700", "Pruszków")
        savePatient("Karolina", "Kosko", "Władysława 12", "75-142", "Gydnia")
        savePatient("Eugeniusz", "Milanowski", "Wolności 125", "56-700", "Lidzbark Waminski")
        savePatient("Nicola", "Milanović", "Biała Rawska 180", "75-765", "Swarzędz")
        savePatient("Michaiło", "Podolyak", "Lekarska 878", "83-700", "Poznań")
        savePatient("Kamil", "Meksykos", "Wolności 121", "11-700", "Mrągowo")
        savePatient("Andrzej", "Dawidowski", "Dawidowo 812", "75-142", "Dawidowo")
        savePatient("Yulia", "Potolska", "Trąbki 5311", "56-700", "Trąbki")
        savePatient("Henryk", "Szary", "Biała Rawska 280", "75-765", "Biała Rawska")
        savePatient("Jarosław", "Duck", "Wiejska 123", "02-200", "Warszawa")

        val appointmentDoctor1 = saveDoctor("Stefan", "Masala", Specialization.CARDIOLOGY)
        val appointmentDoctor2 = saveDoctor("Kamil", "Gębka", Specialization.DERMATOLOGY)
        val appointmentDoctor3 = saveDoctor("Paweł", "Pasternak", Specialization.INFECTIOUS_DISEASE)
        saveDoctor("Wojciech", "Kaliszewski", Specialization.ALLERGY_AND_IMMUNOLOGY)
        saveDoctor("Michał", "Mosa", Specialization.GERIATRICS)
        saveDoctor("Eugeniusz", "Molo", Specialization.CARDIOLOGY)
        saveDoctor("Andrew", "Tate", Specialization.DERMATOLOGY)
        saveDoctor("Gerard", "Kostuch", Specialization.INFECTIOUS_DISEASE)
        saveDoctor("Wojciech", "Malone", Specialization.ALLERGY_AND_IMMUNOLOGY)
        saveDoctor("Maciej", "Gurkowski", Specialization.GERIATRICS)
        saveDoctor("Wojciech", "Nazwiskowski", Specialization.CARDIOLOGY)
        saveDoctor("Kamila", "Gębura", Specialization.DERMATOLOGY)
        saveDoctor("Piotr", "Pasternak", Specialization.INFECTIOUS_DISEASE)
        saveDoctor("Ryszard", "Kalisz", Specialization.ALLERGY_AND_IMMUNOLOGY)
        saveDoctor("Mike", "Tyson", Specialization.GERIATRICS)

        val appointmentPlace1 = savePlace("Prywata klinika RSQ Health", "27 Grudnia 3", "61-737", "Poznań")
        val appointmentPlace2 = savePlace("Publiczna Przychodnia Poznań Jeżyce", "Jeżyce 3", "61-737", "Poznań")
        val appointmentPlace3 = savePlace("Szpital Główny Poznań", "Ulica 12", "61-737", "Poznań")

        saveAppointment(
            appointmentPatient1,
            appointmentDoctor1,
            LocalDateTime.now(defaultClock).plusDays(12).plusHours(12).plusMinutes(15).truncatedTo(MINUTES),
            appointmentPlace1
        )

        saveAppointment(
            appointmentPatient2,
            appointmentDoctor2,
            LocalDateTime.now(defaultClock).plusDays(7).plusHours(12).plusMinutes(45).truncatedTo(MINUTES),
            appointmentPlace2
        )

        saveAppointment(
            appointmentPatient3,
            appointmentDoctor3,
            LocalDateTime.now(defaultClock).plusDays(5).plusHours(17).truncatedTo(MINUTES),
            appointmentPlace3
        )

        saveAppointment(
            appointmentPatient3,
            appointmentDoctor2,
            LocalDateTime.now(defaultClock).plusDays(30).plusHours(17).plusMinutes(15).truncatedTo(MINUTES),
            appointmentPlace2
        )

        saveAppointment(
            appointmentPatient3,
            appointmentDoctor1,
            LocalDateTime.now(defaultClock).plusDays(14).plusHours(11).plusMinutes(30).truncatedTo(MINUTES),
            appointmentPlace1
        )

        logger.info { "GENERATED DUMMY DATA LOADED. TRY API NOW !" }
    }


    private fun savePatient(
        firstname: String,
        lastname: String,
        street: String,
        zipCode: String,
        city: String,
    ) = patientRepository.save(
        PatientEntity().apply {
            this.uuid = UUID.randomUUID().toString()
            this.firstname = firstname
            this.lastname = lastname
            this.street = street
            this.zipCode = zipCode
            this.city = city
        }
    )

    private fun saveDoctor(
        firstname: String,
        lastname: String,
        specialization: Specialization
    ) = doctorRepository.save(
        DoctorEntity().apply {
            this.uuid = UUID.randomUUID().toString()
            this.firstname = firstname
            this.lastname = lastname
            this.specialization = specialization
        }
    )

    private fun saveAppointment(
        patient: PatientEntity,
        doctor: DoctorEntity,
        dateTime: LocalDateTime,
        place: PlaceEntity
    ) = appointmentRepository.save(
        AppointmentEntity().apply {
            this.uuid = UUID.randomUUID().toString()
            this.datetime = dateTime
            this.place = place
            this.doctor = doctor
            this.patient = patient
        }
    )

    private fun savePlace(
        name: String,
        street: String,
        zipCode: String,
        city: String
    ) = placeRepository.save(
        PlaceEntity().apply {
            this.name = name
            this.street = street
            this.zipCode = zipCode
            this.city = city
        }
    )

}