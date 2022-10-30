package org.example.controller;

import org.example.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    /**
     * SQL:
     * INSERT INTO roles(name) VALUES('ROLE_USER');
     * INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
     * INSERT INTO roles(name) VALUES('ROLE_ADMIN');
     */

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/profile")
    public String profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        StringBuilder sb = new StringBuilder();
        for (GrantedAuthority auth : userDetails.getAuthorities()) {
            sb.append(auth.getAuthority()).append(", ");
        }

        return "My profile: " + userDetails.getUsername() +
                "\nAuths: " + sb.toString()+
                "\nToken: "+userDetailsService.getJwtData();
    }


    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}