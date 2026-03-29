package com.mateus.crudeauth.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "registration")
@Table(name = "tb_registration")

public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;


    public Registration(Integer id, String status, LocalDateTime endDate, LocalDateTime startDate, User user) {
        this.id = id;
        this.status = status;
        this.endDate = endDate;
        this.startDate = startDate;
        this.user = user;

    }


    public Registration() {}

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
