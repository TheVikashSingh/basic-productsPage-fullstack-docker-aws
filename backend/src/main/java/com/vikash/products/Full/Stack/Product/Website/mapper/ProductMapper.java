package com.vikash.products.Full.Stack.Product.Website.mapper;

import com.vikash.products.Full.Stack.Product.Website.dto.ProductDTO;
import com.vikash.products.Full.Stack.Product.Website.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ProductMapper {

    ProductEntity toEntity(ProductDTO productDTO);
    ProductDTO toDTO(ProductEntity productEntity);

}
