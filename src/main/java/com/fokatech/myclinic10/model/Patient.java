package com.fokatech.myclinic10.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("PATIENT")
public class Patient extends User{

    private String name;
    private LocalDate date_of_birth;
    private String contact;
    private String medicalHistory;

    // Constructors
    public Patient(){
        // Default
    }

    public Patient(String username, String password, String name, LocalDate date_of_birth, String contact, String medicalHistory){
        super(username, password);
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.contact = contact;
        this.medicalHistory = medicalHistory;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
