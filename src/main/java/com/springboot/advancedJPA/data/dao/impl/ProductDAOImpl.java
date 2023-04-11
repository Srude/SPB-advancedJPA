package com.springboot.advancedJPA.data.dao.impl;

import com.springboot.advancedJPA.data.dao.ProductDAO;
import com.springboot.advancedJPA.entity.ProductEntity;
import com.springboot.advancedJPA.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl  implements ProductDAO {
    private final ProductRepository productRepository;
    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity insertProduct(ProductEntity entity) {
        ProductEntity savedProduct = productRepository.save(entity);

        return savedProduct;
    }

    @Override
    public ProductEntity selectProduct(Long number){
        ProductEntity selectedProduct = productRepository.getById(number);

        return selectedProduct;
    }

    @Override
    public ProductEntity updateProductName(Long number, String name) throws Exception {
        Optional<ProductEntity> selectedProduct = productRepository.findById(number);

        ProductEntity updatedProduct;
        if(selectedProduct.isPresent()) {
            ProductEntity entity = selectedProduct.get();

            entity.setName(name);
            entity.setUpdatedAt(LocalDateTime.now());

            updatedProduct = productRepository.save(entity);
        } else{
            throw new Exception();
        }
        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception{
        Optional<ProductEntity> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()) {
            ProductEntity entity = selectedProduct.get();

            productRepository.delete(entity);
        } else{
            throw new Exception();
        }

    }

}
