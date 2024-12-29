package com.example.kafka002.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class UserResponseDtoSerializer implements Serializer<UserResponseDto> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, UserResponseDto userResponseDto) {
        try {
            return objectMapper.writeValueAsBytes(userResponseDto);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing UserResponseDto", e);
        }
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Configuration logic if needed
    }

    @Override
    public void close() {
        // Clean-up if needed
    }
}
