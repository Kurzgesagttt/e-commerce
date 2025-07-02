package com.Kurzgesagttt.AuthService.config;

import com.Kurzgesagttt.AuthService.model.entity.Role;
import com.Kurzgesagttt.AuthService.model.entity.User;
import com.Kurzgesagttt.AuthService.repository.RoleRepository;
import com.Kurzgesagttt.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Verifica se a role ADMIN já existe
        Role roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name())
                .orElseGet(() -> {
                    Role newAdminRole = new Role();
                    newAdminRole.setName(Role.Values.ADMIN.name());
                    return roleRepository.save(newAdminRole);
                });

        // Verifica se o usuário admin já existe
        var userAdmin = userRepository.findByEmail("admin@admin.com");

        userAdmin.ifPresentOrElse(user -> {
            System.out.println("Admin já existe");
        }, () -> {
            var user = new User();
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setEmail("admin@admin.com");
            user.setCpf("123");
            user.setPassword(bCryptPasswordEncoder.encode("123"));
            user.setRoles(Set.of(roleAdmin));
            userRepository.save(user);
        });
    }

}
