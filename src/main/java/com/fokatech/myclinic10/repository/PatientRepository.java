package com.fokatech.myclinic10.repository;

import com.fokatech.myclinic10.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
