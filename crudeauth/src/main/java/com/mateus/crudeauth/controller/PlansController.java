package com.mateus.crudeauth.controller;

import com.mateus.crudeauth.model.Plans;
import com.mateus.crudeauth.repository.PlansRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")

public class PlansController {

    private final PlansRepository plansRepository;

    public PlansController(PlansRepository plansRepository) {
        this.plansRepository = plansRepository;
    }

    @Operation(description = "Exibe todos os planos")
    @GetMapping
    public ResponseEntity<List<Plans>> getAllPlans() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(plansRepository.findAll());
    }

    @Operation(description = "Cria novos planos")
    @PostMapping
    public ResponseEntity<Plans> savePlans(@RequestBody Plans plans) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(plansRepository.save(plans));

    }

    @Operation(description = "Deleta plano pelo id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlansById(
            @RequestBody Plans plans,
            @PathVariable Integer id) {
        plansRepository.delete(plans);
        return ResponseEntity.ok().body("Deleted Plan Successfully");
    }
}
