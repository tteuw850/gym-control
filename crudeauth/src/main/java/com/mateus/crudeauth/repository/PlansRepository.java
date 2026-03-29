package com.mateus.crudeauth.repository;

import com.mateus.crudeauth.model.Plans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlansRepository extends JpaRepository<Plans, Integer> {

}
