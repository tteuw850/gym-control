package com.mateus.crudeauth.controller;

import com.mateus.crudeauth.model.Registration;
import com.mateus.crudeauth.repository.RegistrationRepository;
import com.mateus.crudeauth.services.RegistrationServices;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")

public class RegistrationController {

    private final RegistrationServices registrationServices;

    public RegistrationController(RegistrationServices registrationServices) {
        this.registrationServices = registrationServices;
    }


    @Operation(description = "Registra matrícula de novos alunos")
    @PostMapping
    public ResponseEntity<Registration> saveRegistration(@RequestBody Registration registration) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(registrationServices.saveRegistration(registration));
    }

    @Operation(description = "Exibe tods matrículas dos alunos")
    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        return  ResponseEntity.ok(registrationServices.getAllRegistrations());
    }

    @Operation(description = "Exibe matrícula do aluno específicado pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(
            @RequestBody Registration registration,
            @PathVariable Integer id) {
        Registration registrationOK = registrationServices.getRegistrationById(id);
        return ResponseEntity.ok(registrationOK);
    }

}
