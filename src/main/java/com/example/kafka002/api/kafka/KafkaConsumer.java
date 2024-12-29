package com.example.kafka002.api.kafka;

import com.example.kafka002.api.model.UserResponseDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "user-topic", groupId = "myGroup")
    public void listen(UserResponseDto userResponseDto){
        System.out.println("Received message: " + userResponseDto);
    }
}
