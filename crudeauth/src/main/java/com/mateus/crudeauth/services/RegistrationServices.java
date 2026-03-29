package com.mateus.crudeauth.services;

import com.mateus.crudeauth.model.Registration;
import com.mateus.crudeauth.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServices {
    private final RegistrationRepository registrationRepository;
    public RegistrationServices(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public Registration saveRegistration(Registration registration) {
        if (registration == null) {
            throw new RuntimeException("Not users registered");
        }
        return registrationRepository.save(registration);
    }

    public List<Registration> getAllRegistrations() {
        if (registrationRepository == null) {
            throw new RuntimeException("Not users registered");
        }
        return registrationRepository.findAll();
    }

    public Registration getRegistrationById(Integer id) {
        if (registrationRepository == null) {
            throw new RuntimeException("Not users registered");
        }
        return registrationRepository.findById(id).orElse(null);
    }
}
