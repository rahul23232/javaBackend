package com.backend.productservice25july.controllers;

import com.backend.productservice25july.dtos.ErrorResponseDto;
import com.backend.productservice25july.dtos.product.*;
import com.backend.productservice25july.models.Product;
import com.backend.productservice25july.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public GetAllProductsResponseDto getAllProducts(){
        List<Product> products = productService.getAllProducts();
        GetAllProductsResponseDto response = new GetAllProductsResponseDto();

        List<GetProductDto> productResponseDtos = new ArrayList<>();

        for (Product product : products) {
            productResponseDtos.add(GetProductDto.from(product));
        }
        response.setProducts(productResponseDtos);

        return response;
    }

    @GetMapping("/{id}")
    public void getSingleProduct(@PathVariable("id") Long id){

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(){

    }

    @PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(
            @PathVariable("id") Long productId,
            @RequestBody CreateProductDto productDto
    ){

        Product product = productService.particalUpdateProduct(productId, productDto.toProduct() );

        PatchProductResponseDto response = new PatchProductResponseDto();
        response.setProduct(GetProductDto.from(product));
        return response;
    }

    public void replaceProduct(){}


//    @RequestMapping(name = "RAHUL", value = "/products")
//    public String anuhttt(){
//        return "Magic";
//    }
}
