package com.food.delivery.Payment.PaymentInterface;

import com.food.delivery.entity.Payment;

public interface PaymentStrategy {
    Payment.PaymentStatus pay(double amount);

   // String toUpperCase();
}
