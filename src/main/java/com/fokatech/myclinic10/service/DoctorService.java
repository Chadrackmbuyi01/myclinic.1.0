package com.fokatech.myclinic10.service;

import com.fokatech.myclinic10.model.Doctor;
import com.fokatech.myclinic10.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id){
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    public Doctor createDoctor(Doctor doctor){
        if (doctor.getUsername() == null || doctor.getSpeciality() == null){
            throw new IllegalArgumentException("Username and speciality are required");
        }
        return doctorRepository.save(doctor);
    }
}
