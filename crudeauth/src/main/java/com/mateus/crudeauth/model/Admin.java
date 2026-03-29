package com.mateus.crudeauth.model;


import com.mateus.crudeauth.dto.LoginRequest;
import jakarta.persistence.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity(name = "tb_admin")
@Table(name = "tb_admin")

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    public Admin(String password, String username, Integer id) {
        this.password = password;
        this.username = username;
        this.id = id;
    }

    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        passwordEncoder.matches(loginRequest.password(), this.password);
        return passwordEncoder.matches(loginRequest.password(), this.password);
    }

    public Admin() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
