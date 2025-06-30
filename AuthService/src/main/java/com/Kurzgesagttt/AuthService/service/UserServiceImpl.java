package com.Kurzgesagttt.AuthService.service;

import com.Kurzgesagttt.AuthService.model.entity.User;
import com.Kurzgesagttt.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

public class UserServiceImpl implements UserService{
=======
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

>>>>>>> eb8b291eed32b1a0afb15684b09fafb6a038b237
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {

    }

    @Override
<<<<<<< HEAD
    public void deleteUser(User user) {
=======
    public void deleteUser(UUID id) {
>>>>>>> eb8b291eed32b1a0afb15684b09fafb6a038b237

    }

    @Override
<<<<<<< HEAD
    public void updateUser(User user) {

=======
    public User updateUser(User user) {
        return null;
>>>>>>> eb8b291eed32b1a0afb15684b09fafb6a038b237
    }
}
