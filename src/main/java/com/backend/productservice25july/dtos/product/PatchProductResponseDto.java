package com.backend.productservice25july.dtos.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchProductResponseDto {
    private GetProductDto product;
}
