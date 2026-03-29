package com.mateus.crudeauth.config;

import com.mateus.crudeauth.model.Admin;
import com.mateus.crudeauth.repository.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.CommandLineRunner;


@Configuration

public class AdminConfig implements CommandLineRunner {


    private final BCryptPasswordEncoder passwordEncoder;

    private final AdminRepository adminRepository;


    public AdminConfig(AdminRepository adminRepository,
                       BCryptPasswordEncoder passwordEncoder) {

        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        var userAdmin = adminRepository.findByUsername("admin");
        userAdmin.ifPresentOrElse(
                (admin) -> System.out.println("admin exists"),
                () -> {
                    var admin = new Admin();
                    admin.setUsername("admin");
                    admin.setPassword(passwordEncoder.encode("123"));
                    adminRepository.save(admin);
                }
                    );
    }



}