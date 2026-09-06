package com.ecom.product_service.controller;

import com.ecom.product_service.dto.ProductRequestDto;
import com.ecom.product_service.dto.ProductResponseDto;
import com.ecom.product_service.entity.Product;
import com.ecom.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/{productId}")
    public ProductResponseDto getProductById(@PathVariable String productId){
        return productService.getProductById(productId);
    }

    @GetMapping("/all")
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @PatchMapping("/{productId}/stock")
    public ProductResponseDto updateStock(@PathVariable String productId, @RequestParam Integer stockQuantity){
        return productService.updateStock(productId,stockQuantity);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable String productId){
        productService.deleteProduct(productId);
        return "Product deleted successfully with ID: "+ productId;
    }


}
