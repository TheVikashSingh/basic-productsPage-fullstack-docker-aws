package com.vikash.products.Full.Stack.Product.Website.service;

import com.vikash.products.Full.Stack.Product.Website.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO addProduct(ProductDTO productDTO);

    void deleteProduct(Long id);

    ProductDTO updateProduct(Long productID, ProductDTO productDTO);
}
