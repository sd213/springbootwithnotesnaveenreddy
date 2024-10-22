package com.telusko.springsecurityex.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  //Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime,
@EnableWebSecurity // To make the spring boot to go for this customized security configuration declared over here in this class
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //Short way of writing

//        // Disable CSRF using the new approach
////        http.csrf(customizer->customizer.disable());
//        http.csrf(csrf -> csrf.disable());
//        // Configure authorization using the modern method
//        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//        http.formLogin(Customizer.withDefaults()); // form login for browser
//        http.httpBasic(Customizer.withDefaults()); // form login for restclients like postman
//        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

//    //Long way of writing
//
//        Customizer<CsrfConfigurer<HttpSecurity>> customizedCsrfAnon = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> csrf) {
//                csrf.disable();
//            }
//        };
//        http.csrf(customizedCsrfAnon); // To disable csrf

//        Customizer<CsrfConfigurer<HttpSecurity>> customizedCsrfAnon = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> csrf) {
//                csrf.disable();
//            }
//        };
//



//        return http.build();
    //Builder Pattern
                // Disable CSRF using the new approach
//        http.csrf(customizer->customizer.disable());
       return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .build();

    }
}
