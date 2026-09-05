package com.ecom.product_service.service;

import com.ecom.product_service.dto.ProductRequestDto;
import com.ecom.product_service.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    ProductResponseDto getProductById(String productId);
    List<ProductResponseDto> getAllProducts();
//    ProductResponseDto updateProduct(ProductRequestDto productRequestDto, String productId);
//    void deleteProduct(String productId);
    ProductResponseDto updateStock(String productId, Integer stockQuantity);
}
