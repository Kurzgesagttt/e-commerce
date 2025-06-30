package com.Kurzgesagttt.AuthService.service;

import com.Kurzgesagttt.AuthService.model.entity.User;
import com.Kurzgesagttt.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteUser(UUID id) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
