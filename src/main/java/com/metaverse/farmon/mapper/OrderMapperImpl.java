package com.metaverse.farmon.mapper;

import com.metaverse.farmon.model.Order;
import com.metaverse.farmon.rest.dto.CreateOrderRequest;
import com.metaverse.farmon.rest.dto.OrderDto;
import com.metaverse.farmon.rest.dto.CreateOrderRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toOrder(CreateOrderRequest createOrderRequest) {
        return new Order(createOrderRequest.getDescription());
    }

    @Override
    public OrderDto toOrderDto(Order order) {
        OrderDto.UserDto userDto = new OrderDto.UserDto(order.getUser().getUsername());
        return new OrderDto(order.getId(), order.getDescription(), userDto, order.getCreatedAt());
    }
}
