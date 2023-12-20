package com.example.dtoslearning.service;


import com.example.dtoslearning.model.UserRestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RestTemplateServiceLayer {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateServiceLayer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserRestTemp consumeApi(){
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1",
                UserRestTemp.class);

    }
}
