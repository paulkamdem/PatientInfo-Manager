package com.pohlig.patientmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pohlig.patientmanager.model.Gender;
import com.pohlig.patientmanager.model.Patient;
import com.pohlig.patientmanager.service.PatientService;
import org.hamcrest.MatcherAssert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.hamcrest.Matchers.*;

@WebMvcTest(PatientApiImpl.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PatientApiTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    private PatientService service;

    @Test
    public void testPatientApiEndpoint() throws Exception {
        MockHttpServletResponse response =  mockMvc.perform(
                MockMvcRequestBuilders.get("/")).andReturn().getResponse();
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }

    @Test
    public void testCreatePatient() throws Exception {

        Patient patient = new Patient();

        patient.setGender(Gender.FEMALE);
        patient.setBirthDate( new Date(96, 6, 13));
        patient.setName("Peter");

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(patient);

        MockHttpServletResponse response =  mockMvc.perform(
                MockMvcRequestBuilders.post("/patients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andReturn().getResponse();
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.CREATED.value()));

    }


    @Test
    public void testDeletePatient() throws Exception {

        MockHttpServletResponse response =  mockMvc.perform(
                MockMvcRequestBuilders.delete("/patients/2")
        ).andReturn().getResponse();
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));

    }

    @Test
    public void testUpdatePatient() throws Exception {

        Patient patient = new Patient();

        patient.setGender(Gender.FEMALE);
        patient.setBirthDate( new Date(98, 6, 13));
        patient.setName("Paul");

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(patient);

        MockHttpServletResponse response =  mockMvc.perform(
                MockMvcRequestBuilders.put("/patients/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andReturn().getResponse();
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));

    }

    @Test
    public void testGetPatient() throws Exception {
        //giv some link or api request: /movie_system/movies
        //make a get request : get
        // 200 from server as response
        MockHttpServletResponse response =  mockMvc.perform(
                MockMvcRequestBuilders.get("/patients/6")
        ).andReturn().getResponse();
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));

    }

}
