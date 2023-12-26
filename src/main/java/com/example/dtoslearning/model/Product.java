package com.example.dtoslearning.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "description",length = 500)
    private String description;
    @Column(name = "category")
    private String category;
    @Column(name = "brand")
    private String brand;

//    public Product(Long productId, String productName, String description, String category, String brand) {
//        this.productId = productId;
//        this.productName = productName;
//        this.description = description;
//        this.category = category;
//        this.brand = brand;
//    }

    //    public Product(Object o, String shoes, String s, String footWear, String nike) {
//    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
