package com.mateus.crudeauth.controller;

import com.mateus.crudeauth.services.UserServices;
import com.mateus.crudeauth.model.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserServices userService;

    public UserController(UserServices userService) {
        this.userService = userService;
    }

    @Operation(description = "Salva novo usuário")
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.saveUser(user));
    }

    @Operation(description = "Exibe todos os usuários")
    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity.ok(userService.getUser());
    }

    @Operation(description = "Deleta usuário pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable  Integer id,
            @RequestBody User user) {
        User getUserById = userService.getUser().get(id);
        return ResponseEntity.ok(getUserById);
    }

    @Operation(description = "Atualiza usuário pelo id")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable("id") Integer id,
            @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @Operation(description = "Deleta usuário pelo id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("Deleted User Successfully");
    }
}
