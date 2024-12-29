package com.example.kafka002.base;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BaseResponse<T>(
        int status,
        LocalDateTime timeStamp,
        String message,
        T data
) {
}
