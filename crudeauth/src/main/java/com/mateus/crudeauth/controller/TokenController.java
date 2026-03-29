package com.mateus.crudeauth.controller;


import com.mateus.crudeauth.dto.LoginRequest;
import com.mateus.crudeauth.dto.LoginResponse;
import com.mateus.crudeauth.repository.AdminRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController

public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public TokenController(JwtEncoder jwtEncoder, AdminRepository adminRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.adminRepository = adminRepository;

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Operation(description = "Login para ter acesso as outras rotas")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var admin = adminRepository.findByUsername(loginRequest.username());

        if (admin.isEmpty() || !admin.get().isLoginCorrect(loginRequest, bCryptPasswordEncoder)){
            throw new BadCredentialsException("Invalid username or password");
        }

        var now = Instant.now();

        var expiresin = 3600L;






        var clains = JwtClaimsSet.builder()
                .issuer("backend")
                .subject(admin.get().getUsername())
                .expiresAt(now.plusSeconds(expiresin))
                .issuedAt(now)
                .build();


        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(clains)).getTokenValue();
        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresin));





    }


}
