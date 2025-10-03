package com.vikash.products.Full.Stack.Product.Website.service;

import com.vikash.products.Full.Stack.Product.Website.dto.ProductDTO;
import com.vikash.products.Full.Stack.Product.Website.entity.ProductEntity;
import com.vikash.products.Full.Stack.Product.Website.mapper.ProductMapper;
import com.vikash.products.Full.Stack.Product.Website.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }


    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        return mapper.toDTO(productRepository.save(mapper.toEntity(productDTO)));
    }

    @Override
    public void deleteProduct(Long id) {
        if(!productRepository.existsById(id)){
            return;
        }
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO updateProduct(Long productID, ProductDTO productDTO) {
        if(!productRepository.existsById(productID)){
            return null;        //need to throw resource not found exception here
        }
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductID(productDTO.getProductID());
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setProductPrice(productDTO.getProductPrice());
        return mapper.toDTO(productRepository.save(productEntity));
    }
}
