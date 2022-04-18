package com.example.client.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    private EurekaClient client;

    @Autowired
    private RestTemplateBuilder templateBuilder;


    @GetMapping()
    public String callService() {
        InstanceInfo instanceInfo = client.getNextServerFromEureka("service", false);
        String url = instanceInfo.getHomePageUrl();

        RestTemplate template = templateBuilder.build();
        ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class);
        return response.getBody();
    }
}
