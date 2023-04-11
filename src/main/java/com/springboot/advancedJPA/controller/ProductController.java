package com.springboot.advancedJPA.controller;

import com.springboot.advancedJPA.data.dto.ChangeProductNameDTO;
import com.springboot.advancedJPA.data.dto.ProductDTO;
import com.springboot.advancedJPA.data.dto.ProductResponseDTO;
import com.springboot.advancedJPA.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<ProductResponseDTO> getProduct(Long number) {
        ProductResponseDTO productResponseDTO = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductResponseDTO productResponseDTO = productService.saveProduct(productDTO);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }
//    {
//        "name" : "enpittsu",
//            "price" : "100",
//            "stock" : "100"
//    }

    @PutMapping()
    public ResponseEntity<ProductResponseDTO> changeProductName(
            @RequestBody ChangeProductNameDTO changeProductNameDTO) throws Exception{
        ProductResponseDTO productResponseDTO = productService.changeProductName(
                changeProductNameDTO.getNumber(), changeProductNameDTO.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("success");
    }



}
