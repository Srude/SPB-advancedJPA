package com.springboot.advancedJPA.service.impl;

import com.springboot.advancedJPA.data.dao.ProductDAO;
import com.springboot.advancedJPA.data.dto.ProductDTO;
import com.springboot.advancedJPA.data.dto.ProductResponseDTO;
import com.springboot.advancedJPA.entity.ProductEntity;
import com.springboot.advancedJPA.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;
    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDTO getProduct(Long number) {
        ProductEntity productEntity = productDAO.selectProduct(number);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setNumber(productEntity.getNumber());
        productResponseDTO.setName(productEntity.getName());
        productResponseDTO.setPrice(productEntity.getPrice());
        productResponseDTO.setStock(productEntity.getStock());


        return productResponseDTO;

    }

    @Override
    public ProductResponseDTO saveProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setStock(productDTO.getStock());
        productEntity.setCreatedAt(LocalDateTime.now());
        productEntity.setUpdatedAt(LocalDateTime.now());

        ProductEntity savedProduct = productDAO.insertProduct(productEntity);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setNumber(savedProduct.getNumber());
        productResponseDTO.setName(savedProduct.getName());
        productResponseDTO.setPrice(savedProduct.getPrice());
        productResponseDTO.setStock(savedProduct.getStock());

        return productResponseDTO;


    }

    @Override
    public ProductResponseDTO changeProductName(Long number, String name) throws Exception {
        ProductEntity changeProductEntity = productDAO.updateProductName(number, name);


        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setNumber(changeProductEntity.getNumber());
        productResponseDTO.setName(changeProductEntity.getName());
        productResponseDTO.setPrice(changeProductEntity.getPrice());
        productResponseDTO.setStock(changeProductEntity.getStock());

        return productResponseDTO;

    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}
