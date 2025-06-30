package com.Kurzgesagttt.AuthService.service;

import com.Kurzgesagttt.AuthService.model.entity.User;
public interface UserService{

    void createUser(User user);
    void deleteUser(User user);
    void updateUser(User user);

}
