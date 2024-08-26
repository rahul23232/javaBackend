package com.backend.productservice25july.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductResponseDto {
    public Long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;
}
