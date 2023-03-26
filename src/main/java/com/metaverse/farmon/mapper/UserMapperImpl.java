package com.metaverse.farmon.mapper;
import com.metaverse.farmon.model.Order;
import com.metaverse.farmon.model.User;
import com.metaverse.farmon.rest.dto.UserDto;

import org.springframework.stereotype.Service;
import com.metaverse.farmon.model.Order;
import java.util.List;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        List<UserDto.OrderDto> orders = user.getOrders().stream().map(this::toUserDtoOrderDto).toList();
        return new UserDto(user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getRole(), orders);
    }

    private UserDto.OrderDto toUserDtoOrderDto(Order order) {
        return new UserDto.OrderDto(order.getId(), order.getDescription(), order.getCreatedAt());
    }
}
