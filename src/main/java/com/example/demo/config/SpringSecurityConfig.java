package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger-ui/index.html#/**").permitAll()
                .anyRequest().authenticated().and().formLogin();
        return http.build();
    }


    @Bean
    protected InMemoryUserDetailsManager adminDetailsManager() {
        UserDetails admin = User.builder().username("Admin")
                .password(passwordEncoder().encode("2222")).roles("Administrator").build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    protected InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.builder().username("User")
                .password(passwordEncoder().encode("1111")).roles("Viewer").build();
        return new InMemoryUserDetailsManager(user);
    }
}
