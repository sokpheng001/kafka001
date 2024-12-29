package com.example.kafka002.api.kafka;

import com.example.kafka002.api.model.CreateUserDto;
import com.example.kafka002.api.model.User;
import com.example.kafka002.api.model.UserResponseDto;
import com.example.kafka002.api.repository.UserRepository;
import com.example.kafka002.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private final static String topic = "user-topic";
    private final KafkaTemplate<String, UserResponseDto> kafkaTemplate;
    private final UserRepository userRepository;
//
    public UserResponseDto sendMessage(CreateUserDto createUserDto){
        User user = new User(new Random().nextInt(9999999) ,createUserDto.name(), createUserDto.email(), UUID.randomUUID().toString()+ LocalDateTime.now(), false);
        userRepository.save(user);
        UserResponseDto userResponseDto  = UserMapper.mapFromUserToUserResponse(user);
        kafkaTemplate.send(topic,userResponseDto);
        return userResponseDto;
    }
}
