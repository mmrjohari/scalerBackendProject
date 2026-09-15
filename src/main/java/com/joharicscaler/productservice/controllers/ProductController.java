package com.joharicscaler.productservice.controllers;

import com.joharicscaler.productservice.dtos.CreateProductRequestDto;
import com.joharicscaler.productservice.models.Product;
import com.joharicscaler.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable long id) {

        return productService.getSingleProduct(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {

        return productService.createProduct(createProductRequestDto);
    }
}
