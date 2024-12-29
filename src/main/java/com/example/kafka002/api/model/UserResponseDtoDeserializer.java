package com.example.kafka002.api.model;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class UserResponseDtoDeserializer implements Deserializer<UserResponseDto> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UserResponseDto deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, UserResponseDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing UserResponseDto", e);
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
