package com.backend.productservice25july.services.sortingService;

import com.backend.productservice25july.models.Product;

import java.util.List;

public interface Sorter {

    List<Product> sort(List<Product> products);
}
