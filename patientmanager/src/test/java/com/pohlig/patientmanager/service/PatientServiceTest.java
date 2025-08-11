package com.pohlig.patientmanager.service;

import com.pohlig.patientmanager.entity.PatientEntity;
import com.pohlig.patientmanager.exception.NotFoundPatientException;
import com.pohlig.patientmanager.model.Gender;
import com.pohlig.patientmanager.model.Patient;
import com.pohlig.patientmanager.repository.PatientRepository;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class PatientServiceTest {
    @InjectMocks
    private PatientService service;

    @Mock
    private PatientRepository repository;

    @Test
    public void testCreatePatient() {

        Patient patient = new Patient();

        patient.setGender(Gender.FEMALE);
        patient.setBirthDate( new Date(96, 6, 13));
        patient.setName("Peter");

        service.createPatient(patient);
        verify(repository, times(1)).save(any());
    }

    @Test
    public void testDeletePatient(){

        Patient patient = new Patient();

        patient.setGender(Gender.MALE);
        patient.setBirthDate( new Date(96, 6, 13));
        patient.setName("Peter");

        PatientEntity entity = service.createPatient(patient);

        when(repository.findById(entity.getPatientId())).thenReturn(Optional.of(entity));

        service.deletePatient(entity.getPatientId());

        verify(repository, times(1)).delete(any());
    }

    @Test(expected = NotFoundPatientException.class)
    public void testhNotFoundPatientException() {

        service.getPatient(3);
    }

    @Test
    public void testGetPatient(){



        Patient patient = new Patient();

        patient.setGender(Gender.MALE);
        patient.setBirthDate( new Date(96, 6, 13));
        patient.setName("Peter");

        PatientEntity entity = service.createPatient(patient);

        when(repository.findById(entity.getPatientId())).thenReturn(Optional.of(entity));


        PatientEntity response = service.getPatient(entity.getPatientId());

        MatcherAssert.assertThat(response, notNullValue());
    }

    @Test
    public void testUpdatePatient(){

        Patient patient = new Patient();

        patient.setGender(Gender.MALE);
        patient.setBirthDate( new Date(96, 6, 13));
        patient.setName("Peter");

        PatientEntity entity = service.createPatient(patient);

        when(repository.findById(entity.getPatientId())).thenReturn(Optional.of(entity));


        Patient newPatient = patient;
        newPatient.setName("Paul");
        service.updatePatient(entity.getPatientId(), newPatient);

        //first time: save for create; second time : save with update
        verify(repository, times(2)).save(any());
    }

}
