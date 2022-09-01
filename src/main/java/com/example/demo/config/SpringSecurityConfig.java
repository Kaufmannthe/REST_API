package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/swagger/**").hasRole("Viewer")
                .antMatchers(HttpMethod.POST, "/swagger/**").hasRole("Administrator")
                .antMatchers(HttpMethod.PUT, "/swagger/**").hasRole("Administrator")
                .antMatchers(HttpMethod.DELETE, "/swagger/**").hasRole("Administrator")
                .and()
                .csrf().disable()
                .formLogin().loginPage("/login");
              /*  .authorizeRequests()
                .antMatchers("/swagger/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();*/
        return http.build();
    }



    @Bean
    protected InMemoryUserDetailsManager userDetailsManager() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails admin = User.builder().username("Admin")
                .password(passwordEncoder().encode("2222")).roles("Viewer","Administrator").build();
        UserDetails user = User.builder().username("User")
                .password(passwordEncoder().encode("1111")).roles("Viewer").build();
        inMemoryUserDetailsManager.createUser(admin);
        inMemoryUserDetailsManager.createUser(user);
        return inMemoryUserDetailsManager;
    }


}
