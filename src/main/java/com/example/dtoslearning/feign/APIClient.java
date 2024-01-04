package com.example.dtoslearning.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@FeignClient(value = "feignDemo",url = "http://localhost:8085/api")
public interface APIClient {
    @GetMapping("/username")
    public String userName();
}
