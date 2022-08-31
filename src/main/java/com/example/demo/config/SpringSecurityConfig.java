package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/swagger/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
        return http.build();
    }

    @Bean
    protected InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.builder().username("Admin")
                .password(passwordEncoder().encode("Admin")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user);
    }

}
