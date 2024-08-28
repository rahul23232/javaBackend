package com.backend.productservice25july.services;

import com.backend.productservice25july.models.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product particalUpdateProduct(Long productId, Product product);
}
