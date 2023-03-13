package com.metaverse.farmon.mapper;

import com.metaverse.farmon.model.User;
import com.metaverse.farmon.rest.dto.UserDto;


public interface UserMapper {

    UserDto toUserDto(User user);
}