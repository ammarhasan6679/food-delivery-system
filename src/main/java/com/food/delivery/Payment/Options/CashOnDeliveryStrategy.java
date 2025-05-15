package com.food.delivery.Payment.Options;

import com.food.delivery.Payment.PaymentInterface.PaymentStrategy;
import com.food.delivery.entity.Payment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component("COD")

public class CashOnDeliveryStrategy implements PaymentStrategy {

    @Override
    public Payment.PaymentStatus pay(double amount) {
        System.out.println("Pair Rs " + amount + "through Cash");
        return Payment.PaymentStatus.SUCCESS;
    }
}
