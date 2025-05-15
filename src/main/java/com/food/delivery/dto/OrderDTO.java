package com.food.delivery.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private Long userId;
    private Long restaurantId;
    private String orderDate;
    private String status;
    private Double totalAmount;

    public OrderDTO(){

    }
    public OrderDTO(Long id, Long userId, Long restaurantId, String orderDate, String status, Double totalAmount) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }


}
