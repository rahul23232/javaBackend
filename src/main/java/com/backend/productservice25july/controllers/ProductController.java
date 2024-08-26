package com.backend.productservice25july.controllers;

import com.backend.productservice25july.dtos.CreateProductRequestDto;
import com.backend.productservice25july.dtos.CreateProductResponseDto;
import com.backend.productservice25july.models.Product;
import com.backend.productservice25july.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

//    @Value("${productService}")
//    private String productServiceType;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
       //return "This product is priced at: "+ createProductRequestDto.getPrice();
        Product product = productService.createProduct(createProductRequestDto.toProduct());

        return CreateProductResponseDto.fromProduct(product);

    }

    @GetMapping("")
    public void getAllProducts(){

    }

    @GetMapping("/{id}")
    public void getSingleProduct(@PathVariable("id") Long id){

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(){

    }

//    @RequestMapping(name = "RAHUL", value = "/products")
//    public String anuhttt(){
//        return "Magic";
//    }
}
