package com.ecom.product_service.mapper;

import com.ecom.product_service.dto.ProductResponseDto;
import com.ecom.product_service.entity.Product;

public class ProductMapping {

    //Entity → Response DTO
    public static ProductResponseDto toProductResponseDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProductId(product.getProductId());
        productResponseDto.setName(product.getName());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStockQuantity(product.getStockQuantity());
        productResponseDto.setInStock(product.getInStock());
        productResponseDto.setCategoryName(product.getCategory().getName());
        return productResponseDto;
    }

    //Request DTO → Entity
    public static Product toProductEntity(ProductResponseDto productResponseDto){
        Product product = new Product();
        product.setProductId(productResponseDto.getProductId());
        product.setName(productResponseDto.getName());
        product.setDescription(productResponseDto.getDescription());
        product.setPrice(productResponseDto.getPrice());
        product.setStockQuantity(productResponseDto.getStockQuantity());
        product.setInStock(productResponseDto.getInStock());
        return product;

    }
}
