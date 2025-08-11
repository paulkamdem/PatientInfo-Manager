package com.pohlig.patientmanager.controller;

import com.pohlig.patientmanager.entity.PatientEntity;
import com.pohlig.patientmanager.model.Patient;
import org.springframework.web.bind.annotation.*;
import org.springframework.lang.NonNull;
import org.springframework.http.ResponseEntity;

@RequestMapping
public interface PatientApi {

    //test api
    @GetMapping("/")
    String testApi();


    //GET /patients/:id – Details eines Patienten
    @GetMapping("/patients/{patientId}")
    ResponseEntity<PatientEntity> getPatient(@NonNull @PathVariable long patientId);



    //POST /patients – Neuen Patienten anlegen
    @PostMapping("/patients")
    ResponseEntity<PatientEntity> createPatient(@RequestBody Patient patient);


    //PUT /patients/:id – Patienten aktualisieren
    @PutMapping("/patients/{patientId}")
    ResponseEntity<PatientEntity> updatePatient(@NonNull @PathVariable long patientId, @RequestBody Patient patient);



    //DELETE /patients/:id – Patienten löschen
    @DeleteMapping("/patients/{patientId}")
    ResponseEntity<PatientEntity> deletePatient(@NonNull @PathVariable long patientId);
}
