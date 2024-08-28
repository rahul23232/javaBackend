package com.backend.productservice25july.services;

import com.backend.productservice25july.dtos.fakeStore.FakeStoreCreateProductRequestDto;
import com.backend.productservice25july.dtos.fakeStore.FakeStoreGetProductResponseDto;
import com.backend.productservice25july.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
        FakeStoreGetProductResponseDto response = restTemplate.postForObject("https://fakestoreapi.com/products",
                request,
                FakeStoreGetProductResponseDto.class);

//        Product product1 = new Product();
//        product1.setId(response.getId());
//        product1.setTitle(response.getTitle());
//        product1.setDescription(response.getDescription());
//        product1.setPrice(response.getPrice());
//        product1.setImageUrl(response.getImage());
//        product1.setCategoryName(response.getCategory());

        return response.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {

        //throw new RuntimeException();

        FakeStoreGetProductResponseDto[] response =  restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreGetProductResponseDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreGetProductResponseDto fakeStoreGetProductResponseDto : response){
            products.add(fakeStoreGetProductResponseDto.toProduct());
        }
        return products;
    }

    @Override
    public Product particalUpdateProduct(Long productId, Product product) {

        HttpEntity<FakeStoreCreateProductRequestDto> requestEntity = new HttpEntity<>(FakeStoreCreateProductRequestDto.fromProduct(product));
        ResponseEntity<FakeStoreGetProductResponseDto> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + productId,
                HttpMethod.PATCH,
                requestEntity,
                FakeStoreGetProductResponseDto.class
        );


        return responseEntity.getBody().toProduct();
    }
}
