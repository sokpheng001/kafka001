package com.example.kafka002.api.kafka;

import com.example.kafka002.api.model.CreateUserDto;
import com.example.kafka002.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/users/kafka")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaProducer kafkaProducer;
    @PostMapping("/publish")
    public BaseResponse<Object> publish(@RequestBody CreateUserDto createUserDto){
        kafkaProducer.sendMessage(createUserDto);
        return BaseResponse.builder()
                .status(HttpStatus.CREATED.value())
                .timeStamp(LocalDateTime.now())
                .message("User has been created successfully")
                .data(kafkaProducer.sendMessage(createUserDto))
                .build();
    }
}
