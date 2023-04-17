package com.springboot.advancedJPA.data.repository;

import com.springboot.advancedJPA.data.entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByNumber(Long number);
    List<ProductEntity> findallByName(String name);
    ProductEntity queryByNumber(Long number);


    boolean existsByNumber(Long number);


    long countByName(String name);


    void deleteByNumber(Long number);
    long removeByName(String name);


    List<ProductEntity> findFirstByName(String name);
    List<ProductEntity> findTop10ByName(String name);





    ProductEntity findByNumberIs(Long number);
    ProductEntity findByNumberEquals(Long number);


    ProductEntity findByNumberIsNot(Long number);
    ProductEntity findByNumberNot(Long number);


    List<ProductEntity> findByUpdatedAtNull();
    List<ProductEntity> findByUpdatedAtIsNull();
    List<ProductEntity> findByUpdatedAtNotNull();
    List<ProductEntity> findByUpdatedAtIsNotNull();


    ProductEntity findByisActiveTrue();
    ProductEntity findByisActiveIsTrue();
    ProductEntity findByisActiveFalse();
    ProductEntity findByisActiveIsFalse();


    ProductEntity findByNumberAndName(Long number, String name);
    ProductEntity findByNumberOrName(Long number, String name);


    List<ProductEntity> findByPriceIsGreaterThan(Long price);
    List<ProductEntity> findByPriceGreaterThan(Long price);
    List<ProductEntity> findByPriceGreaterThanEqual(Long price);
    List<ProductEntity> findByPriceIsLessThan(Long price);
    List<ProductEntity> findByPriceLessThan(Long price);
    List<ProductEntity> findByPriceLessThanEqual(Long price);
    List<ProductEntity> findByPriceIsBetween(Long price, Long highPrice);
    List<ProductEntity> findByPriceBetween(Long price, Long highPrice);



    List<ProductEntity> findByNameLike(String name);
    List<ProductEntity> findByNameIsLike(String name);

    List<ProductEntity> findByNameContains(String name);
    List<ProductEntity> findByNameContaining(String name);
    List<ProductEntity> findByNameIsContaining(String name);

    List<ProductEntity> findByNameStartsWith(String name);
    List<ProductEntity> findByNameStartingWith(String name);
    List<ProductEntity> findByNameIsStartingWith(String name);

    List<ProductEntity> findByNameEndsWith(String name);
    List<ProductEntity> findByNameEndingWith(String name);
    List<ProductEntity> findByNameIsEndingWith(String name);


    List<ProductEntity> findByNameOrderByNumberAsc(String name);
    List<ProductEntity> findByNameOrderByNumberDesc(String name);


    List<ProductEntity> findByNameOrderByPriceAscStockDesc(String name);


    List<ProductEntity> findByName(String name, Sort sort);

}
