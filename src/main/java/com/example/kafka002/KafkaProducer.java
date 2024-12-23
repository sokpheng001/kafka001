package com.example.kafka002;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private final static String topic = "test-topic";
    private final KafkaTemplate<String, String> kafkaTemplate;
//
    public void sendMessage(String message){
        kafkaTemplate.send(topic,message);
        System.out.println("Message sent: " + message);
    }
}
