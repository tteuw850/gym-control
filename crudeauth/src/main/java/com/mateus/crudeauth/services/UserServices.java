package com.mateus.crudeauth.services;

import com.mateus.crudeauth.model.User;
import com.mateus.crudeauth.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class UserServices {

    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {

        if (user==null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is null");
        }

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is required");

        }

        if (user.getHeight() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Height is required");
        }

        if (user.getWeight() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Weight is required");
        }

        if (user.getFlat() == null || user.getFlat().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Flat is required");
        }

        if (user.getObjective() == null || user.getObjective().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Objective is required");
        }


        return userRepository.save(user);
    }

    public List<User> getUser() {
        if (userRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUser(Integer id) {

        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public User updateUser(Integer id, User user) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found " + id));

        if (id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID invalid");
        }

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not null");
        }

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is required");
        }

        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is required");
        }

        if (user.getHeight() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Height is required");
        }

        if (user.getWeight() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Weight is required");
        }

        if (user.getFlat() == null || user.getFlat().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Flat is required");
        }

        if (user.getObjective() == null || user.getObjective().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Objective is required");
        }

        if (user.getStatus()==null || user.getStatus().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status is required");
        }



        existing.setName(user.getName());
        existing.setHeight(user.getHeight());
        existing.setWeight(user.getWeight());
        existing.setObjective(user.getObjective());
        existing.setFlat(user.getFlat());
        existing.setEmail(user.getEmail());
        existing.setObjective(user.getObjective());
        existing.setStatus(user.getStatus());

        return userRepository.save(existing);


    }
}