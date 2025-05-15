package com.food.delivery.Controller;

import com.food.delivery.dto.PaymentDTO;
import com.food.delivery.service.interfaces.PaymentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentServiceInterface paymentService;

    @PostMapping("/pay")
    public ResponseEntity<PaymentDTO> pay(@RequestBody PaymentDTO dto){
        PaymentDTO response = paymentService.makePayment(dto);
        return ResponseEntity.ok(response);
    }
}
