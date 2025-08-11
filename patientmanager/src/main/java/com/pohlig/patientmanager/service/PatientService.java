package com.pohlig.patientmanager.service;

import com.pohlig.patientmanager.entity.PatientEntity;
import com.pohlig.patientmanager.exception.NotFoundPatientException;
import com.pohlig.patientmanager.model.Patient;
import com.pohlig.patientmanager.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientEntity createPatient(Patient patient) {

        PatientEntity entity = new PatientEntity();
        entity.setName(patient.getName());
        entity.setGender(patient.getGender());
        entity.setBirthDate(patient.getBirthDate());
        patientRepository.save(entity);

        return entity;

    }

    public PatientEntity getPatient(long patientId) {
        Optional<PatientEntity> entity = patientRepository.findById(patientId);
        if (entity.isEmpty()) {
            throw new NotFoundPatientException( String.format("Patient id %s doest not exist in db", patientId));
        } else {
            return entity.get();
        }
    }

    public PatientEntity updatePatient(long patientId, Patient newPatient) {
        PatientEntity existingEntity = getPatient(patientId);

        existingEntity.setBirthDate(newPatient.getBirthDate());
        existingEntity.setName(newPatient.getName());
        existingEntity.setGender(newPatient.getGender());

        patientRepository.save(existingEntity);
        return existingEntity;
    }

    public PatientEntity deletePatient(long patientId) {
        PatientEntity existingEntity = getPatient(patientId);

        patientRepository.delete(existingEntity);
        return existingEntity;
    }
}
