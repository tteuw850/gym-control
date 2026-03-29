package com.mateus.crudeauth.repository;

import com.mateus.crudeauth.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
}
