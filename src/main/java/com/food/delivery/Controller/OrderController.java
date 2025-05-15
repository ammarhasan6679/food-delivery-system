package com.food.delivery.Controller;


import com.food.delivery.dto.OrderDTO;
import com.food.delivery.entity.Order;
import com.food.delivery.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO dto) {
        OrderDTO saved = orderService.placeOrder(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<OrderDTO> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        OrderDTO updated = orderService.updateOrderStatus(id, status);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDTO>> getOrderHistory(@PathVariable Long userId) {
        List<OrderDTO> list = orderService.getOrderHistory(userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
//        Order savedOrder = orderService.placeOrder(order);
//        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}/status")
//    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
//        Order updatedOrder = orderService.updateOrderStatus(id, status);
//        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
//    }
//
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Order>> getOrderHistory(@PathVariable Long userId) {
//        List<Order> orders = orderService.getOrderHistory(userId);
//        return new ResponseEntity<>(orders, HttpStatus.OK);
//    }
}
