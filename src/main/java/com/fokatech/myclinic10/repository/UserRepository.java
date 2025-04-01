package com.fokatech.myclinic10.repository;

import com.fokatech.myclinic10.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
