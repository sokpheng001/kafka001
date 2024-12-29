package com.example.kafka002.api.kafka;

import com.example.kafka002.api.model.UserResponseDto;
import com.example.kafka002.api.websocket.WebSocketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final WebSocketService webSocketService;
    @KafkaListener(topics = "user-topic", groupId = "user-group")

    public void listen(String message) throws JsonProcessingException {
        // Convert the string to UserResponseDto
        ObjectMapper objectMapper = new ObjectMapper();
        UserResponseDto userResponseDto = objectMapper.readValue(message, UserResponseDto.class);
//        webSocketService.sendMessage(userResponseDto);
        // Now you can use the userResponseDto
        System.out.println("This is the user has been created: " + userResponseDto);
    }

}
