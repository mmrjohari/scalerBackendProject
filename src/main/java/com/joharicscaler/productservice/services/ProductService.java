package com.joharicscaler.productservice.services;

import com.joharicscaler.productservice.exceptions.ProductNotFoundException;
import com.joharicscaler.productservice.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(long id) throws ProductNotFoundException;

    Product createProduct(
            String title,
            String description,
            double price,
            String imageUrl,
            String category);
}
