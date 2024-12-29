package com.example.kafka002.api.websocket;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import org.springframework.stereotype.Component;

@Component
public class WebSocketHandler implements org.springframework.web.socket.WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Connection established");
    }

    @Override
    public void handleMessage(WebSocketSession session, org.springframework.web.socket.WebSocketMessage<?> message) {
        // Handle the message here
        try {
            String payload = (String) message.getPayload();
            // Respond with a message
            session.sendMessage(new TextMessage("Echo: " + payload));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        System.out.println("Error occurred: " + exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus closeStatus) throws Exception {
        System.out.println("Connection closed");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}
