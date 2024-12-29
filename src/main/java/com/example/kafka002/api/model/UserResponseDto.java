package com.example.kafka002.api.model;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;

@Builder
public record UserResponseDto(
        Integer id,
        String name,
        String email,
        String password,
//        #
        Boolean isDeleted
) {
}
