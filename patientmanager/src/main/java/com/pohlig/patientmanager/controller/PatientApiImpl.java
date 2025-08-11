package com.pohlig.patientmanager.controller;

import com.pohlig.patientmanager.entity.PatientEntity;
import com.pohlig.patientmanager.model.Patient;
import com.pohlig.patientmanager.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PatientApiImpl implements PatientApi{

    private PatientService service;
    @Override
    public String testApi() {
        return "PatientManager Api works well";
    }

    @Override
    public ResponseEntity<PatientEntity> getPatient(long patientId) {
        return new ResponseEntity<>(service.getPatient(patientId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PatientEntity> createPatient(Patient patient) {
        return new ResponseEntity<>(service.createPatient(patient), HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<PatientEntity> updatePatient(long patientId, Patient patient) {
        return new ResponseEntity<>(service.updatePatient(patientId,patient), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PatientEntity> deletePatient(long patientId) {
        return new ResponseEntity<>(service.deletePatient(patientId), HttpStatus.OK);
    }
}
