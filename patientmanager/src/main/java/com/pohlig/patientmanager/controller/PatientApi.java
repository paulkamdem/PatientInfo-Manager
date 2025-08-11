package com.pohlig.patientmanager.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping
public interface PatientApi {
    @GetMapping("/")
    public String testApi();
}
