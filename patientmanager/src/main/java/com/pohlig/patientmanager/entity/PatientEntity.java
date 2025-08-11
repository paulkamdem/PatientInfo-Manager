package com.pohlig.patientmanager.entity;

import com.pohlig.patientmanager.model.Gender;
import lombok.Data;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "Patient")
@Data
public class PatientEntity {
    @Id
    @GeneratedValue
    private long patientId;

    private String name;
    private Date birthDate;
    private Gender gender;
}
