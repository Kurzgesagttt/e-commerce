package com.Kurzgesagttt.AuthService.service;

import com.Kurzgesagttt.AuthService.model.entity.User;

import java.util.UUID;

public interface UserService{

    void createUser(User user);
<<<<<<< HEAD
    void deleteUser(User user);
    void updateUser(User user);
    //void loginService();

=======
    void deleteUser(UUID id);
    User updateUser(User user);
>>>>>>> eb8b291eed32b1a0afb15684b09fafb6a038b237

}
