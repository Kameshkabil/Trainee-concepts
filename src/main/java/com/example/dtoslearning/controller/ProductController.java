package com.example.dtoslearning.controller;


import com.example.dtoslearning.exceptions.ProductNotFoundException;
import com.example.dtoslearning.model.Product;
import com.example.dtoslearning.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/create-products")
    public ResponseEntity<String> createNewProductsData(@RequestBody Product product){
        productService.createProducts(product);
        return new ResponseEntity<>("Product Created", HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/template/products",method = RequestMethod.POST)
//    public String createProducts(@RequestBody Product product){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
//
//        return restTemplate.exchange(
//                "http://localhost:8081/products",HttpMethod.POST,entity,String.class).getBody();
//    }

    @GetMapping("/search/products")
    public List<Product> searchProductName(@RequestParam("query") String query) throws ProductNotFoundException {

        List<Product> product = productService.user_filter_search_products(query);
        return product;
    }
}
