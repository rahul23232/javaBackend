package com.backend.productservice25july.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
@Entity
public class Category extends BaseModel {
    @Column(nullable = false, unique = true, name = "category_name")
    private String name;
    @Basic(fetch = FetchType.LAZY)
    private String description;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> featuredProducts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Fetch(FetchMode.SELECT)
    private List<Product> allProducts;

    @OneToOne(cascade = {})
    private Subcategory subcategories;

    private int countOfProducts;
}
