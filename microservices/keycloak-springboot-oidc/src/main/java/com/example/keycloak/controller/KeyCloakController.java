package com.example.keycloak.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author irfan.nagoo
 */

@RestController
@RequestMapping("/keycloak")
@Slf4j
public class KeyCloakController {


    @GetMapping("/hello")
    public Map<String, Object> sayHello(@AuthenticationPrincipal OAuth2User principalUser) {
        log.info("sayHello: Start");
        String userName = principalUser != null ? principalUser.getAttribute("name") : "Unknown";
        return Map.of("user",
                String.format("Hello from API Server with Authenticated User [%s]", userName));
    }
}
