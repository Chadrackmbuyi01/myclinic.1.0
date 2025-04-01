package com.fokatech.myclinic10.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DOCTOR")
public class Doctor extends User{
    private String name;
    private String speciality;

    @Column(name = "availability")
    private String availability; // e.g., "Mon - Fri, 9am - 5am

    //Constructors
    public Doctor(){
        // Default
    }
    public Doctor(String name, String speciality, String availability){
        this.name = name;
        this.speciality = speciality;
        this.availability = availability;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
