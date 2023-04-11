package com.springboot.advancedJPA.service;

import com.springboot.advancedJPA.data.dto.ProductDTO;
import com.springboot.advancedJPA.data.dto.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO getProduct(Long number);
    ProductResponseDTO saveProduct(ProductDTO productDTO);
    ProductResponseDTO changeProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}