package com.food.delivery.service.interfaces;

import com.food.delivery.Payment.PaymentInterface.PaymentStrategy;
import com.food.delivery.dto.PaymentDTO;
import com.food.delivery.entity.Payment;

public interface PaymentServiceInterface {
    PaymentDTO makePayment(PaymentDTO dto);
}
