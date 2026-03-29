package com.mateus.crudeauth.services;

import com.mateus.crudeauth.model.Plans;
import com.mateus.crudeauth.repository.PlansRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PlansServices {

    private final PlansRepository plansRepository;


    public PlansServices(PlansRepository plansRepository) {
        this.plansRepository = plansRepository;
    }


    public List<Plans> getAllPlans() {
        if(plansRepository.findAll().isEmpty()) {
            throw new RuntimeException("No plans found");
        }
        return plansRepository.findAll();
    }

    @Transactional
    public Plans savePlans(Plans plans) {
        if(plans.getName() == null){
            throw new IllegalArgumentException("Plans name is null");
        }
        return plansRepository.save(plans);
    }
}
