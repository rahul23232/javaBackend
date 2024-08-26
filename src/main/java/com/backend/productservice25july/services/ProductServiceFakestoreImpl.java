package com.backend.productservice25july.services;

import com.backend.productservice25july.dtos.FakeStoreCreateProductRequestDto;
import com.backend.productservice25july.dtos.FakeStoreCreateProductResponseDto;
import com.backend.productservice25july.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class ProductServiceFakestoreImpl implements ProductService{

    public RestTemplate restTemplate;

    public ProductServiceFakestoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto request = new FakeStoreCreateProductRequestDto();
        request.setCategory(product.getCategoryName());
        request.setTitle(product.getTitle());
        request.setImage(product.getImageUrl());
        request.setDescription(product.getDescription());
        request.setPrice(product.getPrice());
        FakeStoreCreateProductResponseDto response = restTemplate.postForObject("https://fakestoreapi.com/products",
                request,
                FakeStoreCreateProductResponseDto.class);

        Product product1 = new Product();
        product1.setId(response.getId());
        product1.setTitle(response.getTitle());
        product1.setDescription(response.getDescription());
        product1.setPrice(response.getPrice());
        product1.setImageUrl(response.getImage());
        product1.setCategoryName(response.getCategory());

        return product1;
    }
}
