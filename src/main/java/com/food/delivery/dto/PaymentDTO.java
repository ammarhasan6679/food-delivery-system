package com.food.delivery.dto;

import com.food.delivery.entity.Payment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class PaymentDTO {
    private Long id;
    private Double amount;
    private String paymentMethod;
    private String status;
    private Long orderId;
    private LocalDateTime timestamp;

    public PaymentDTO() {

    }

    public PaymentDTO(Long id, Double amount, String paymentMethod, String status, Long orderId, LocalDateTime timestamp) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.orderId = orderId;
        this.timestamp = timestamp;
    }



}
