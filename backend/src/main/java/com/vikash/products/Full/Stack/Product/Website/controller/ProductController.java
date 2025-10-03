package com.vikash.products.Full.Stack.Product.Website.controller;

import com.vikash.products.Full.Stack.Product.Website.dto.ProductDTO;
import com.vikash.products.Full.Stack.Product.Website.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO){
        return productService.addProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id,productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
