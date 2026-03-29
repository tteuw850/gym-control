package com.mateus.crudeauth.dto;

import com.mateus.crudeauth.repository.UserRepository;

public record LoginRequest(String username, String password) {

}
