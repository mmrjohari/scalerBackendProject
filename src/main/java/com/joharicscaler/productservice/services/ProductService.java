package com.joharicscaler.productservice.services;

import com.joharicscaler.productservice.dtos.CreateProductRequestDto;
import com.joharicscaler.productservice.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(long id);

    Product createProduct(CreateProductRequestDto createProductRequestDto);
}
