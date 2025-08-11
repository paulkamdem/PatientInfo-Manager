package com.pohlig.patientmanager.controller;

import org.hamcrest.MatcherAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.*;

@WebMvcTest(PatientApiImpl.class)
public class PatientApiTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testPatientApiEndpoint() throws Exception {
        MockHttpServletResponse response =  mockMvc.perform(
                MockMvcRequestBuilders.get("/")).andReturn().getResponse();
        MatcherAssert.assertThat(response.getStatus(), is(HttpStatus.OK.value()));
    }
}
