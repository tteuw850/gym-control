package com.mateus.crudeauth.repository;

import com.mateus.crudeauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    void deleteById(Integer Id);
    Optional<User> findByName(String name);

}
