package com.food.delivery.Payment.Options;

import com.food.delivery.Payment.PaymentInterface.PaymentStrategy;
import com.food.delivery.entity.Payment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component("CARD")

public class CardPaymentStrategy implements PaymentStrategy {

    public Payment.PaymentStatus pay(double amount) {
        System.out.println("Processing Card payment of ₹" + amount);
        return Payment.PaymentStatus.SUCCESS;
    }
}
