package com.login.Demo.User.Database.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/")
    public String home() {
        return "🚀 App desplegada correctamente en Railway!";
    }
}