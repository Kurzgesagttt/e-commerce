package com.Kurzgesagttt.AuthService.controller;

import com.Kurzgesagttt.AuthService.mapper.UserMapper;
import com.Kurzgesagttt.AuthService.model.dto.CreateUserRequestDTO;
import com.Kurzgesagttt.AuthService.model.entity.User;
import com.Kurzgesagttt.AuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestDTO dto){
            User newUser = userMapper.convertToEntity(dto);

            userService.createUser(newUser);
        return ResponseEntity.ok().build();
    }


}
