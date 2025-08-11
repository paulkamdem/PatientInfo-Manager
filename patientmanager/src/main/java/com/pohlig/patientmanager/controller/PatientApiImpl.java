package com.pohlig.patientmanager.controller;

import com.pohlig.patientmanager.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PatientApiImpl implements PatientApi{
    @Override
    public String testApi() {
        return "PatientManager Api works well";
    }

    @Override
    public ResponseEntity<Patient> getPatient(long patientId) {
        return null;
    }

    @Override
    public ResponseEntity<Patient> createPatient(long patientId) {
        return null;
    }

    @Override
    public ResponseEntity<Patient> updatePatient(long patientId) {
        return null;
    }

    @Override
    public ResponseEntity<Patient> deletePatient(long patientId) {
        return null;
    }
}
