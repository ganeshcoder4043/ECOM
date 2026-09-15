package com.ecom.order_service.service;

import com.ecom.order_service.dto.ProductResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ProductClient {

    private final RestTemplate restTemplate;

    public ProductClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*public ProductResponseDTO getProductName(String productId){
//        String url = "http://localhost:6000/ecommerce/products/" + productId;
        String url = "http://product-service/ecommerce/products/" + productId;
        return restTemplate.getForObject(url, ProductResponseDTO.class);
    }

    public void updateStock(String productId, int quantity){
//        String url = "http://localhost:6000/ecommerce/products/" + productId + "/stock?stockQuantity=" + quantity;
//        String url = "http://localhost:6000/ecommerce/products/" + productId + "/stock?stockQuantity=" + quantity;
        String url = "http://product-service/ecommerce/products/" + productId + "/stock?stockQuantity=" + quantity;
//        restTemplate.patchForObject(url, null, Void.class);
        restTemplate.put(url, null);
    }*/


    public ProductResponseDTO getProductName(String productId) {
        // ✅ Service name (Eureka registered name)
        String url = "http://product-service/ecommerce/products/" + productId;
        log.info("Calling Product Service: {}", url);
        return restTemplate.getForObject(url, ProductResponseDTO.class);
    }

    public void updateStock(String productId, int quantity) {
        String url = "http://product-service/ecommerce/products/" + productId + "/stock?stockQuantity=" + quantity;
        log.info("Updating stock: {}", url);
        restTemplate.put(url, null);
    }
}
