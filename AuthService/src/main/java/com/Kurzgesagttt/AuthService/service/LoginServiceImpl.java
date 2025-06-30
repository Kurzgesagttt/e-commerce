package com.Kurzgesagttt.AuthService.service;

import com.Kurzgesagttt.AuthService.model.dto.LoginRequestDTO;
import com.Kurzgesagttt.AuthService.model.entity.User;
import com.Kurzgesagttt.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    public User login(LoginRequestDTO loginRequest){

        var user = userRepository.findByEmail(loginRequest.email());

        //FIXME

        if (user.isEmpty() || user.get().isLoginCorrect(loginRequest, bCryptPasswordEncoder) ){
            throw new BadCredentialsException("Email or password is invalid");
        }
    }




}
