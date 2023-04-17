package com.springboot.advancedJPA.data.dao;

import com.springboot.advancedJPA.data.entity.ProductEntity;

public interface ProductDAO {
    ProductEntity insertProduct(ProductEntity entity);
    ProductEntity selectProduct(Long number);
    ProductEntity updateProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;

}

