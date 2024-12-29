package com.example.kafka002.api.websocket;

import com.example.kafka002.api.model.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebSocketService {
    private final SimpMessagingTemplate messagingTemplate;
    public void sendMessage(UserResponseDto userResponseDto){
        messagingTemplate.convertAndSend(userResponseDto);
    }
}
