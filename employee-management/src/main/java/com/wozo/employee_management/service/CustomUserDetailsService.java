package com.wozo.employee_management.service;

import com.wozo.employee_management.entity.AppUser;
import com.wozo.employee_management.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomUserDetailsService  implements UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = userRepository.findByUsername(username);

        if(appUser == null){
            throw new UsernameNotFoundException("Username not found with name"+username);
        }

        return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .authorities("EMPLOYEE_READ")
                .build();

    }
}
