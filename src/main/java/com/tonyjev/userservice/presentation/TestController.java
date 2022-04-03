package com.tonyjev.userservice.presentation;

import com.tonyjev.userservice.presentation.vo.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class TestController {
    private final Greeting greeting;

    @GetMapping("/health-check")
    public String status() {
        return "It's Working in User Service.";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getMessage();
    }

}
