package com.example.kafka002.api.model;

import lombok.Builder;

@Builder
public record CreateUserDto(
        String name,
        String email,
        String password
) {
}
