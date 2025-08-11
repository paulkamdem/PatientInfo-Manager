package com.pohlig.patientmanager.repository;

import com.pohlig.patientmanager.entity.PatientEntity;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<PatientEntity, Long> {

}
