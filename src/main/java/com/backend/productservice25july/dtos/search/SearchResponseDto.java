package com.backend.productservice25july.dtos.search;

import com.backend.productservice25july.dtos.product.GetProductDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class SearchResponseDto {
    private Page<GetProductDto> productsPage;
}
