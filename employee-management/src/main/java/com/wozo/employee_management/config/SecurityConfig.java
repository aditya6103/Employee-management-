package com.wozo.employee_management.config;


import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


       @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

           http
                   .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                           .requestMatchers("/Employees","/Employees/**").hasAuthority("EMPLOYEE_READ")
                           .requestMatchers("/departments","/departments/**").hasAuthority("DEPARTMENT_READ")
                           .anyRequest().authenticated()
                   )

                   // This line resists 403 Forbidden error and pop-up default login page
                   .formLogin(Customizer.withDefaults());

           return http.build();


      }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//      @Bean
//      public UserDetailsService userDetailsService()
//      {
//          UserDetails user= User.builder()
//                  .username("Aditya")
//                  .password("{noop}12345")
//                  .authorities("EMPLOYEE_READ")
//                  .build();
//          UserDetails admin= User.builder()
//                  .username("Admin")
//                  .password("{noop}123")
//                  .authorities( "EMPLOYEE_READ",
//                          "EMPLOYEE_WRITE",
//                          "EMPLOYEE_DELETE",
//                          "DEPARTMENT_READ",
//                          "DEPARTMENT_WRITE")
//                  .build();
//
//          return new InMemoryUserDetailsManager(user,admin);
//
//      }





}
