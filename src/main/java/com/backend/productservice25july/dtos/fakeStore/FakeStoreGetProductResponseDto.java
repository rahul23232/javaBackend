package com.backend.productservice25july.dtos.fakeStore;

import com.backend.productservice25july.models.Category;
import com.backend.productservice25july.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreGetProductResponseDto {
    public Long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(this.getId());
        product.setTitle(this.getTitle());
        product.setDescription(this.getDescription());
        product.setImageUrl(this.getImage());
        Category category = new Category();
        category.setName(this.getCategory());
        product.setCategory(category);
        product.setPrice(this.getPrice());

        return product;
    }
}
