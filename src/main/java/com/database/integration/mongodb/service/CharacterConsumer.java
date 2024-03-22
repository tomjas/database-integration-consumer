package com.database.integration.mongodb.service;

import com.database.integration.mongodb.dto.MonogCharacterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CharacterConsumer {

    private final IntegrationService integrationService;

    @KafkaListener(topics = {"${kafka.topic}"}, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(MonogCharacterDto dto) {
        log.debug("Received message {}", dto);
        integrationService.saveOrUpdate(dto);
    }
}
