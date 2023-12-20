package com.example.dtoslearning.controller;

import com.example.dtoslearning.model.UserRestTemp;
import com.example.dtoslearning.service.RestTemplateServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class RestTemplateController {
    @Autowired
    RestTemplateServiceLayer restTemplateServiceLayer;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public ResponseEntity<UserRestTemp> getData(){
        return new ResponseEntity<>(restTemplateServiceLayer.consumeApi(), HttpStatus.OK);

    }
    //if you want return string
//    @RequestMapping(value = "/template/products")
//    public String getProductList() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        return restTemplate.exchange(
//                "http://localhost:8080/",
//                HttpMethod.GET,
//                entity,
//                String.class
//        ).getBody();
//    }

    //if you want return object(json obj)
    @RequestMapping(value = "/template/products")
    public UserRestTemp getUserDataList(){
        UserRestTemp userRestTemp = restTemplate.getForEntity("http://localhost:8080/",UserRestTemp.class)
                .getBody();
        return userRestTemp;
    }
}
