package com.springboot.advancedJPA.repository;

import com.springboot.advancedJPA.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
