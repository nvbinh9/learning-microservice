package com.example.configclient.controller;

import com.example.configclient.controller.config.ClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Autowired
    private ClientConfig config;

    @GetMapping("/config")
    public String printConfig(){
        return config.getProperty();
    }
}
