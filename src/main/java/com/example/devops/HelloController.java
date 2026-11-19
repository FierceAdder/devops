package com.example.devops;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @Value("${spring.application.name:devops-pipeline-app}")
    private String appName;

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
                "application", appName,
                "status", "running",
                "message", "Hello from DevOps CI/CD Pipeline!"
        );
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, DevOps!";
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }
}
