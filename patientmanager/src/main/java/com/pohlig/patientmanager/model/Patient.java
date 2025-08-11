package com.pohlig.patientmanager.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Patient {
    //Patientenliste anzeigen (Name, Geburtsdatum, Geschlecht, etc…)
    private long patientId;
    private String name;
    private Date birthDate;
    private Gender gender;

}
