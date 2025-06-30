package com.Kurzgesagttt.AuthService.service;

import com.Kurzgesagttt.AuthService.model.entity.User;
import com.Kurzgesagttt.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }
}
