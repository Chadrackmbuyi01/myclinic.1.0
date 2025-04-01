package com.fokatech.myclinic10.repository;

import com.fokatech.myclinic10.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
