package com.example.kafka002;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "test-topic", groupId = "myGroup")
    public void listen(String message){
        System.out.println("Received message: " + message);
    }
}
