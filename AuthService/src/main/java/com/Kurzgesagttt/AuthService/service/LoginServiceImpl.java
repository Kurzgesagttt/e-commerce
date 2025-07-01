package com.Kurzgesagttt.AuthService.service;

import com.Kurzgesagttt.AuthService.model.dto.LoginRequestDTO;
import com.Kurzgesagttt.AuthService.model.dto.LoginResponseDTO;
import com.Kurzgesagttt.AuthService.model.entity.User;
import com.Kurzgesagttt.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LoginServiceImpl {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    JwtEncoder jwtEncoder;
    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginResponseDTO login(LoginRequestDTO loginRequest){

        var user = userRepository.findByEmail(loginRequest.email());

        if (user.isEmpty() || user.get().isLoginCorrect(loginRequest, bCryptPasswordEncoder) ){
            throw new BadCredentialsException("Email or password is invalid");
        }
        var now = Instant.now();
        var expiresIn = 300l;

        var claims = JwtClaimsSet.builder()
                .issuer("kurzgesagtttbkcd")
                .subject(user.get().getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();
        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponseDTO(jwtValue,expiresIn);
    }




}
