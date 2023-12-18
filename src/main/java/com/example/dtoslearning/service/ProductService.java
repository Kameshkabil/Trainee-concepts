package com.example.dtoslearning.service;


import com.example.dtoslearning.exceptions.ProductNotFoundException;
import com.example.dtoslearning.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    EntityManager entityManager;


    @Transactional
    public void createProducts(Product product){
        entityManager.persist(product);
    }

    public List<Product> user_filter_search_products(String query) throws ProductNotFoundException {
        String splitWord = query.substring(0,3);
        System.out.println(splitWord);
        String jpql = "SELECT p FROM Product p WHERE p.productName LIKE :searchTerm";
        TypedQuery<Product> typedQuery = entityManager.createQuery(jpql,Product.class);
        typedQuery.setParameter("searchTerm",splitWord+"%");
        List<Product> resultList =  typedQuery.getResultList();

        if(resultList.isEmpty()){
            throw new ProductNotFoundException("Product Not Available");
        }
        return resultList;
    }
}
