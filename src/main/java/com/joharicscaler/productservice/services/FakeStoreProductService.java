package com.joharicscaler.productservice.services;

import com.joharicscaler.productservice.dtos.FakeStoreProductDto;
import com.joharicscaler.productservice.exceptions.ProductNotFoundException;
import com.joharicscaler.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        /* To Product without using stream
        List<Product> productList = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            Product p = fakeStoreProductDto.toProduct();
            productList.add(p);
        }
        return productList;
        */

        return Arrays.stream(fakeStoreProductDtos).map(a -> a.toProduct()).toList();
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException{
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        if(fakeStoreProductDto == null) throw new ProductNotFoundException("Product with the id " + id + " isn't available");
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product createProduct(
            String title,
            String description,
            double price,
            String imageUrl,
            String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);
        fakeStoreProductDto.setCategory(category);

        FakeStoreProductDto fakeStoreProductDto1 = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class);

        return fakeStoreProductDto1.toProduct();
    }
}
