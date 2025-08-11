package com.pohlig.patientmanager.model;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    NON_BINARY("Non-binary"),
    OTHER("Other");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
