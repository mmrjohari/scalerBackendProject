package com.joharicscaler.productservice.dtos;

import com.joharicscaler.productservice.models.Category;
import com.joharicscaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public Product toProduct() {
        Product product = new Product();

        product.setCategory(new Category(1, category));
        product.setDescription(description);
        product.setTitle(title);
        product.setImageUrl(image);
        product.setPrice(price);

        return product;
    }
}
