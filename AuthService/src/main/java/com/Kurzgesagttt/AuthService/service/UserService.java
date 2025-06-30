package com.Kurzgesagttt.AuthService.service;

import com.Kurzgesagttt.AuthService.model.entity.User;

import java.util.UUID;

public interface UserService{

    void createUser(User user);
    void deleteUser(UUID id);
    User updateUser(User user);

}
