package com.ecom.payment_service.entity;

import com.ecom.payment_service.dto.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    private String paymentId;
    private String orderId;
    private String customerId;
    private String amount;
    private LocalDate paymentDate;
    private PaymentStatus paymentStatus;
}
