package com.example.kafka002.api.kafka;

import com.example.kafka002.api.model.UserResponseDto;
import com.example.kafka002.api.model.UserResponseDtoSerializer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {
    @Bean
    public KafkaTemplate<String, UserResponseDto> kafkaTemplate() {
        ProducerFactory<String, UserResponseDto> producerFactory = new DefaultKafkaProducerFactory<>(producerConfig());
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public Map<String, Object> producerConfig() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Adjust this to your Kafka server's address
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, UserResponseDtoSerializer.class); // Use custom serializer
        return configProps;
    }
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("user-topic")
                .partitions(1)
                .replicas(1)
                .build();

    }
}
