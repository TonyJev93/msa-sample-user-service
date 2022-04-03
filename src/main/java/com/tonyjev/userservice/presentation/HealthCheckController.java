package com.tonyjev.userservice.presentation;

import com.tonyjev.userservice.presentation.vo.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class HealthCheckController {
    public final Environment env;
    private final Greeting greeting;

    @GetMapping("/health-check")
    public String status() {
        return String.format("It's Working in User Service on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping({"/", "/welcome"})
    public String welcome() {
        return greeting.getMessage();
    }

}
