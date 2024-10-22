package com.telusko.springsecurityex.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  //Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime,
@EnableWebSecurity // To make the spring boot to go for this customized security configuration declared over here in this class
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .build();

    }

    @Bean
    public UserDetailsService userDetailsService(){
            UserDetails user1 = User.withDefaultPasswordEncoder().username("kiran").password("K@123").roles("USER").build();
            UserDetails user2 = User.withDefaultPasswordEncoder().username("som").password("s@123").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user1,user2);

    }
    /*The UserDetailsService interface in Spring Security is a core component that is responsible for retrieving user-related data. It is primarily used for the authentication process. Here’s a detailed explanation of its purpose and how it works:

Purpose of UserDetailsService
User Data Retrieval:

The primary role of UserDetailsService is to load user-specific data from a data source (like a database) when an authentication request is made.
It retrieves a user's details, including their username, password, roles, and any other relevant attributes required for authentication.
Integration with Spring Security:

Spring Security uses the UserDetailsService interface to obtain user details during the authentication process.
By implementing this interface, you provide a way for Spring Security to find and authenticate users based on your application's specific needs.
Custom User Details:

You can create a custom implementation of UserDetailsService to suit your application's requirements.
This allows you to define how user information is retrieved, including handling additional user attributes and implementing custom logic for user retrieval.*/
}
