package com.wozo.employee_management.config;


import com.wozo.employee_management.entity.AppUser;
import com.wozo.employee_management.entity.Role;
import com.wozo.employee_management.repository.RoleRepository;
import com.wozo.employee_management.repository.UserRepository;
import lombok.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
@Data
@Configuration
@AllArgsConstructor
public class DataInitializer {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner init() {
        return args -> {

            if (!roleRepository.existsByRoleName("ADMIN")) {

                Role adminRole = new Role();
                adminRole.setRoleName("ADMIN");

                roleRepository.save(adminRole);
            }

            if (!roleRepository.existsByRoleName("USER")) {

                Role userRole = new Role();
                userRole.setRoleName("USER");

                roleRepository.save(userRole);
            }

            if (userRepository.findByUsername("Aditya") == null) {

                AppUser user = new AppUser();

                user.setUsername("Aditya");
                user.setPassword(passwordEncoder.encode("12345"));

                Role userRole = roleRepository.findByRoleName("USER");

                user.setRoles(Set.of(userRole));

                userRepository.save(user);

            }

            if (userRepository.findByUsername("Admin") == null) {

                AppUser admin = new AppUser();

                admin.setUsername("Admin");
                admin.setPassword(passwordEncoder.encode("123"));

                Role adminRole = roleRepository.findByRoleName("ADMIN");

                admin.setRoles(Set.of(adminRole));

                userRepository.save(admin);

            }


        };
    }




}
