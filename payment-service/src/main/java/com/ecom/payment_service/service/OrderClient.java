package com.ecom.payment_service.service;

import com.ecom.payment_service.dto.OrderStatusUpdateRequestDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderClient {

    private final RestTemplate restTemplate;

    public OrderClient(RestTemplate restTemplate) {  // also use resttemplatebuilder for auto-configured
        this.restTemplate = restTemplate;
    }

    public void updateOrderStatus(String orderId, String status){
//        http://localhost:7000/orders/ord-057d72c4/status?status=CONFIRMED
        String url = "http://localhost:7000/orders/"+ orderId + "/status?status=" + status;
        OrderStatusUpdateRequestDTO request = new OrderStatusUpdateRequestDTO(orderId, status);
        String response = restTemplate.patchForObject(url, request, String.class);
        System.out.println("Order status update: " + response);
    }
}
