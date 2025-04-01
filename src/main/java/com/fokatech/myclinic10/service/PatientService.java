package com.fokatech.myclinic10.service;

import com.fokatech.myclinic10.model.Patient;
import com.fokatech.myclinic10.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id){
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    public Patient createPatient(Patient patient){
        if (patient.getUsername() == null || patient.getPassword() == null){
            throw new IllegalArgumentException("Username and name are required for Patient");
        }
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patientDetails){
        Patient patient = getPatientById(id);
        patient.setUsername(patientDetails.getUsername());
        patient.setPassword(patientDetails.getPassword());
        patient.setName(patientDetails.getName());
        patient.setDate_of_birth(patientDetails.getDate_of_birth());
        patient.setContact(patientDetails.getContact());
        patient.setMedicalHistory(patientDetails.getMedicalHistory());
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id){
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
    }
}
