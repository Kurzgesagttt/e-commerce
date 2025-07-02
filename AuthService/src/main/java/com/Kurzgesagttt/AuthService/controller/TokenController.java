package com.Kurzgesagttt.AuthService.controller;

import com.Kurzgesagttt.AuthService.model.dto.LoginRequestDTO;
import com.Kurzgesagttt.AuthService.model.dto.LoginResponseDTO;
import com.Kurzgesagttt.AuthService.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    @Autowired
    private  JwtEncoder jwtEncoder;

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto){
        //TODO
        LoginResponseDTO responseDTO = loginService.login(dto);
        return ResponseEntity.ok(responseDTO);
    }

}
