package com.food.delivery.service.impl;

import com.food.delivery.Payment.Options.CardPaymentStrategy;
import com.food.delivery.Payment.Options.CashOnDeliveryStrategy;
import com.food.delivery.Payment.Options.UPIPaymentStrategy;
import com.food.delivery.Payment.Options.WalletPaymentStrategy;
import com.food.delivery.Payment.PaymentContext;
import com.food.delivery.Payment.PaymentInterface.PaymentStrategy;
import com.food.delivery.dto.PaymentDTO;
import com.food.delivery.entity.Order;
import com.food.delivery.entity.Payment;
import com.food.delivery.repository.OrderRepository;
import com.food.delivery.repository.PaymentRepository;
import com.food.delivery.service.interfaces.PaymentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImp implements PaymentServiceInterface {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentContext paymentContext;

    @Override
    public PaymentDTO makePayment(PaymentDTO dto) {
        if (dto.getOrderId() == null) {
            throw new IllegalArgumentException("Order ID must not be null");
        }
        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Payment payment = new Payment();
        payment.setAmount(dto.getAmount());
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setOrder(order);
        payment.setTimestamp(LocalDateTime.now());

        // Use context to get strategy from method
        String method = dto.getPaymentMethod().toUpperCase();
        Payment.PaymentStatus status = paymentContext.pay(method, dto.getAmount());
        payment.setStatus(status);

        Payment saved = paymentRepository.save(payment);

        // Map to DTO
        PaymentDTO result = new PaymentDTO();
        result.setId(saved.getId());
        result.setAmount(saved.getAmount());
        result.setStatus(saved.getStatus().toString());
        result.setPaymentMethod(saved.getPaymentMethod());
        result.setTimestamp(saved.getTimestamp());
        result.setOrderId(saved.getOrder().getId());

        return result;
    }
}
//public class PaymentServiceImp implements PaymentServiceInterface {
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Override
//    public PaymentDTO makePayment(PaymentDTO dto) {
//        Order order = orderRepository.findById(dto.getOrderId())
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//
//        Payment payment = new Payment();
//        payment.setAmount(dto.getAmount());
//        payment.setPaymentMethod(dto.getPaymentMethod());
//        payment.setOrder(order);
//        payment.setTimestamp(LocalDateTime.now());
//
//        PaymentContext context = new PaymentContext();
//        String method = dto.getPaymentMethod().toUpperCase();
//
//        switch (method) {
//            case "CARD":
//                context.setStrategy(new CardPaymentStrategy());
//                break;
//            case "UPI":
//                context.setStrategy(new UPIPaymentStrategy());
//                break;
//            case "WALLET":
//                context.setStrategy(new WalletPaymentStrategy());
//                break;
//            case "COD":
//                context.setStrategy(new CashOnDeliveryStrategy());
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid payment method");
//        }
//
//        Payment.PaymentStatus status = context.pay(dto.getAmount());
//        payment.setStatus(status);
//
//        Payment saved = paymentRepository.save(payment);
//
//        // Map to DTO
//        PaymentDTO result = new PaymentDTO();
//        result.setId(saved.getId());
//        result.setAmount(saved.getAmount());
//        result.setStatus(saved.getStatus().toString());
//        result.setPaymentMethod(saved.getPaymentMethod());
//        result.setTimestamp(saved.getTimestamp());
//        result.setOrderId(saved.getOrder().getId());
//
//        return result;

//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Override
//    public Payment processPayment(Long orderId, Double amount, PaymentStrategy paymentstrategy) {
//        Order order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//        PaymentContext context = new PaymentContext();
//        switch(paymentstrategy.toUpperCase()){
//            case"UPI":
//                context.setStrategy(new UPIPaymentStrategy());
//                break;
//
//            case"CARD":
//                context.setStrategy(new CardPaymentStrategy());
//                break;
//
//            case"WALLET":
//                context.setStrategy(new WalletPaymentStrategy());
//                break;
//
//            case"COD":
//                context.setStrategy(new CashOnDeliveryStrategy());
//                break;
//
//            default:
//                throw new RuntimeException("Invalid payment method");
//        }
//        context.pay(amount);
//        Payment payment = new Payment();
//        payment.setAmount(amount);
//        payment.setPaymentMethod(paymentstrategy.toString());
//        payment.setStatus(Payment.PaymentStatus.SUCCESS);
//        payment.setTimestamp(LocalDateTime.now());
//        paymentRepository.save(payment);
//        return payment;

//    }
//}
