package com.example.demo.configuration;

import com.example.demo.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity http,JwtFilter jwt)
    {
        System.out.println("its working");
        return http.csrf(crpf->crpf.disable()).cors(cors -> {}).formLogin(form->form.disable()).httpBasic(http1->http1.disable()).authorizeHttpRequests(auth->auth
                .requestMatchers("/auth/**").permitAll().anyRequest().authenticated())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwt , UsernamePasswordAuthenticationFilter.class).build();

    }
}
