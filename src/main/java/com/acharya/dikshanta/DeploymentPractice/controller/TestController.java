package com.acharya.dikshanta.DeploymentPractice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class TestController {

    @GetMapping("/check")
    public ResponseEntity<String> getHealthStatus(HttpServletRequest request) {
     String message=String.format("Tomcat is running in %s with SessionId: %s",
             request.getServerName(),request.getSession().getId());
     return ResponseEntity.ok(message);
    }
}
