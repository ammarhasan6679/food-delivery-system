package com.food.delivery.service.interfaces;
//placeOrder(userId)	Convert cart → order
//getOrderHistory(userId)	View past orders
//updateOrderStatus(orderId)	Admin updates order status


import com.food.delivery.dto.OrderDTO;
import com.food.delivery.entity.Order;

import java.util.List;

public interface OrderService {
    OrderDTO placeOrder(OrderDTO dto);
    OrderDTO updateOrderStatus(long id, String newStatus);
    List<OrderDTO> getOrderHistory(long userId);
//    List<Order> getAllPlacedOrders();
//    List<Order> getAllNotPlacedOrders();

}
