package com.dhineshkanna.dkgt.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controlling {

    @GetMapping("/greet")
    public String greeting(HttpServletRequest request) {
        return "Welcome to Practice Coding" + request.getSession().getId();
    }
}
