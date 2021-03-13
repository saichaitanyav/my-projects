package com.myretail.project.productservice.model;


import java.util.Collection;

@Data
public class ProductDTO {
    private Long productId;
    private String name;
    private ProductPrice price;

    public ProductDTO(Product product, ProductPrice price) {
        this.id = product.getProductId();
        this.name = product.getName();
        this.price = price;
    }
}