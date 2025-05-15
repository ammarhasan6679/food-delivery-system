package com.food.delivery.service.impl;

import com.food.delivery.dto.OrderDTO;
import com.food.delivery.entity.Order;
import com.food.delivery.entity.Restaurant;
import com.food.delivery.entity.User;
import com.food.delivery.repository.OrderRepository;
import com.food.delivery.repository.RestaurantRepository;
import com.food.delivery.repository.UserRepository;
import com.food.delivery.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Place Order
    @Override
    public OrderDTO placeOrder(OrderDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Order order = toEntity(dto, user, restaurant);
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now().toString());

        return toDTO(orderRepository.save(order));
    }

    @Override
    public OrderDTO updateOrderStatus(long id, String newStatus) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(newStatus);
        return toDTO(orderRepository.save(order));
    }

    @Override
    public List<OrderDTO> getOrderHistory(long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        if (orders.isEmpty()) {
            throw new RuntimeException("No orders found for user with ID: " + userId);
        }
        return orders.stream().map(this::toDTO).collect(Collectors.toList());
    }



    private OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUser().getId());
        dto.setRestaurantId(order.getRestaurant().getId());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus());
        dto.setTotalAmount(order.getTotalAmount());
        return dto;
    }

    private Order toEntity(OrderDTO dto, User user, Restaurant restaurant) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setOrderDate(dto.getOrderDate());
        order.setStatus(dto.getStatus());
        order.setTotalAmount(dto.getTotalAmount());
        return order;
    }
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Override
//    public Order placeOrder(Order order){
//        order.setStatus("PLACED");
//        order.setOrderDate(LocalDate.now().toString());
//        return orderRepository.save(order);
//    }
//    @Override
//    public Order updateOrderStatus(long id,String newStatus){
//        Optional<Order> optionalOrder = orderRepository.findById(id);
//        if(optionalOrder.isEmpty()){
//            throw new RuntimeException("Order not found");
//        }
//        Order order = optionalOrder.get();
//        order.setStatus(newStatus);
//        return orderRepository.save(order);
//    }
//
//    @Override
//    public List<Order> getOrderHistory(long user_id){
//        List<Order> orders = orderRepository.findByUserId(user_id);
//        if (orders.isEmpty()) {
//            throw new RuntimeException("No orders found for user with ID: " + user_id);
//        }
//        return orders;
//    }
}
