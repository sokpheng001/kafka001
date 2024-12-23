package com.example.kafka002;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer kafkaProducer;
    @PostMapping("/publish")
    public String publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return "Message sent: " + message;
    }
}
