package com.example.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Value("${service.instance.name}")
    private String instance;

    @GetMapping()
    public String sayHello() {
        return "Hello World: " +instance;
    }
}
