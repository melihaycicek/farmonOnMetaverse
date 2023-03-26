package com.metaverse.farmon.mapper;
import com.metaverse.farmon.model.Order;

import com.metaverse.farmon.rest.dto.CreateOrderRequest;
import com.metaverse.farmon.rest.dto.OrderDto;

public interface OrderMapper {

    Order toOrder(CreateOrderRequest createOrderRequest);

    OrderDto toOrderDto(Order order);
}