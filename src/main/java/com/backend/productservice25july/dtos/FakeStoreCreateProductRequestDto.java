package com.backend.productservice25july.dtos;

import com.backend.productservice25july.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductRequestDto {
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

    public static FakeStoreCreateProductRequestDto fromProduct(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreCreateProductRequestDto = new FakeStoreCreateProductRequestDto();
        fakeStoreCreateProductRequestDto.title = product.getTitle();
        fakeStoreCreateProductRequestDto.price = product.getPrice();
        fakeStoreCreateProductRequestDto.category = product.getCategoryName();
        fakeStoreCreateProductRequestDto.description = product.getDescription();
        fakeStoreCreateProductRequestDto.image = product.getImageUrl();
        return fakeStoreCreateProductRequestDto;

    }

}
