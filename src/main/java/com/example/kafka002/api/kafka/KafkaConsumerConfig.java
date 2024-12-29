package com.example.kafka002.api.kafka;

import com.example.kafka002.api.model.UserResponseDto;
import com.example.kafka002.api.model.UserResponseDtoDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, UserResponseDto> consumerFactory() {
        Map<String, Object> consumerProps = new HashMap<>();
        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "user-group");
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, UserResponseDtoDeserializer.class);
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(consumerProps);
    }

    @Bean
    public ConcurrentMessageListenerContainer<String, UserResponseDto> messageListenerContainer() {
        // Create the listener
        MessageListener<String, UserResponseDto> messageListener = record -> {
            UserResponseDto userResponseDto = record.value();
            // Logic for processing the message
            System.out.println("Received message: " + userResponseDto);
        };

        // Create ContainerProperties and set the listener
        ContainerProperties containerProps = new ContainerProperties("test-topic"); // Set topic name
        containerProps.setMessageListener(messageListener);

        // Create and return the ConcurrentMessageListenerContainer
        return new ConcurrentMessageListenerContainer<>(consumerFactory(), containerProps);
    }

    @KafkaListener(topics = "test-topic", groupId = "user-group")
    public void listen(UserResponseDto userResponseDto) {
        // Your listener logic here
        System.out.println("Received message in listener: " + userResponseDto);
    }
}
