package com.pohlig.patientmanager.controller;

import com.pohlig.patientmanager.model.Patient;
import org.springframework.web.bind.annotation.*;
import org.springframework.lang.NonNull;
import org.springframework.http.ResponseEntity;

@RequestMapping
public interface PatientApi {

    //test api
    @GetMapping("/")
    public String testApi();


    //GET /patients/:id – Details eines Patienten
    @GetMapping("/patients/{patientId}")
    public ResponseEntity<Patient> getPatient(@NonNull @PathVariable long patientId);



    //POST /patients – Neuen Patienten anlegen
    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@NonNull @PathVariable long patientId);


    //PUT /patients/:id – Patienten aktualisieren
    @PutMapping("/patients/{patientId}")
    public ResponseEntity<Patient> updatePatient(@NonNull @PathVariable long patientId);



    //DELETE /patients/:id – Patienten löschen
    @DeleteMapping("/patients/{patientId}")
    public ResponseEntity<Patient> deletePatient(@NonNull @PathVariable long patientId);
}
