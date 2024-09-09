package com.backend.productservice25july.repositories;

import com.backend.productservice25july.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

    //    List<Category> findByIdGreaterThanAndNameGreaterThan(
    //       Long id, String name);

            Category save(Category category);
}
