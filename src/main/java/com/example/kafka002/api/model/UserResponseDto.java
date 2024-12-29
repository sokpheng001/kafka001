package com.example.kafka002.api.model;

import lombok.Builder;

@Builder
public record UserResponseDto(
        Integer id,
        String name,
        String email,
//        #
        Boolean isDeleted
) {
}
