package com.example.dtoslearning.controller;


import com.example.dtoslearning.model.Product;
import com.example.dtoslearning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/create-products")
    public ResponseEntity<String> createNewProductsData(@RequestBody Product product){
        productService.createProducts(product);
        return new ResponseEntity<>("Product Created", HttpStatus.CREATED);
    }

    @GetMapping("/search/products")
    public List<Product> searchProductName(@RequestParam("query") String query){
        List<Product> product = productService.user_filter_search_products(query);
        return product;
    }
}
