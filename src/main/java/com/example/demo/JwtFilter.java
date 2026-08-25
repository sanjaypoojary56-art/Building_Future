package com.example.demo;

import com.example.demo.configuration.SecurityConfig;
import com.example.demo.services.JwtService;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService filterservice;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String authheader=request.getHeader("Authorization");
            if(authheader==null || !authheader.startsWith("Bearer "))
            {
                filterChain.doFilter(request,response);
                return;
            }
            String token=authheader.substring(7);
            try {

                    String email=filterservice.extarctEmail(token);
                    String role=filterservice.extractRole(token);
                    var auth=new SimpleGrantedAuthority("ROLE_"+role);
                    UsernamePasswordAuthenticationToken up=new UsernamePasswordAuthenticationToken(email,null, List.of(auth));

                    SecurityContextHolder.getContext().setAuthentication(up);

                    filterChain.doFilter(request,response);


            }
            catch(Exception e)
            {
                throw new JwtException("Not a valid tocken");
            }
    }

}
