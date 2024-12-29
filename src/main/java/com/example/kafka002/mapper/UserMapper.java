package com.example.kafka002.mapper;

import com.example.kafka002.api.model.User;
import com.example.kafka002.api.model.UserResponseDto;

public class UserMapper {
    public static UserResponseDto mapFromUserToUserResponse(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .isDeleted(user.getIsDeleted())
                .build();
    }
}
