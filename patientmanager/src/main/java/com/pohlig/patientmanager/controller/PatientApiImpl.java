package com.pohlig.patientmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PatientApiImpl implements PatientApi{
    @Override
    public String testApi() {
        return "PatientManager Api works well";
    }
}
