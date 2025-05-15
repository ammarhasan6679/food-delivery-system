package com.food.delivery.Payment;

import com.food.delivery.Payment.PaymentInterface.PaymentStrategy;
import com.food.delivery.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component
@Service
public class PaymentContext {
    @Autowired

    private final Map<String, PaymentStrategy> strategyMap;

    @Autowired
    public PaymentContext(Map<String, PaymentStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }
    public Payment.PaymentStatus pay(String strategyKey, double amount) {
        PaymentStrategy strategy = strategyMap.get(strategyKey.toUpperCase());

        if (strategy == null) {
            throw new IllegalArgumentException("Invalid payment strategy: " + strategyKey);
        }

        return strategy.pay(amount);
    }
}
