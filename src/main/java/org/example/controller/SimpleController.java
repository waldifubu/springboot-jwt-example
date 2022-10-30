package org.example.controller;

import org.example.model.Tutorial;
import org.example.payload.response.MessageResponse;
import org.example.repository.TutorialRepository;
import org.example.security.jwt.JwtUtils;
import org.example.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    TutorialRepository tutorialRepository;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping({"/", "/index"})
    //@PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    public String homePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("appName", appName+ authentication.getName());
        return "home";
    }

    @GetMapping("/home")
    public String homePage() {
        return "redirect:/";
    }

    @GetMapping("/login")
    //@PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    public String login() {
        return "login";
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping("/tutorials")
    @PostMapping("/tutorials")
    public String homePage2(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("tutoriallist", tutorialRepository.findAll());
        return "tutorials";
    }

    @GetMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
}
