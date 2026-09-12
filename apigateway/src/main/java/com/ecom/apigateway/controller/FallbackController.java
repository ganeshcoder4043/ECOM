package com.ecom.apigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    /* product service*/
    @GetMapping("/fallback/product")
    public ResponseEntity<String> fallbackProduct(){
        return ResponseEntity.ok("Product service is currently unavailable. Please try again later");
    }
    @PostMapping("/fallback/product")
    public ResponseEntity<String> fallbackProductCreate(){
        return ResponseEntity.ok("Product service is currently unavailable. Please try again later");
    }

    /* order service*/

    @GetMapping("/fallback/order")
    public ResponseEntity<String> fallbackOrder(){
        return ResponseEntity.ok("Order service is currently unavailable. Please try again later");
    }
    @PostMapping("/fallback/order")
    public ResponseEntity<String> fallbackOrderCreate(){
        return ResponseEntity.ok("Order service is currently unavailable. Please try again later");
    }


    /* payment service */
    @GetMapping("/fallback/payment")
    public ResponseEntity<String> fallbackPayment(){
        return ResponseEntity.ok("Payment service is currently unavailable. Please try again later");
    }

    @PostMapping("/fallback/payment")
    public ResponseEntity<String> fallbackPaymentCreate(){
        return ResponseEntity.ok("Payment service is currently unavailable. Please try again later");
    }




}
