package com.database.integration.mongodb.service;


import com.database.integration.mongodb.dto.MonogCharacterDto;
import com.database.integration.mongodb.model.MonogCharacter;
import com.database.integration.mongodb.repository.MongoCharacterRepository;
import com.database.integration.mongodb.util.CharacterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class IntegrationService {

    private final MongoCharacterRepository mongodbRepository;

    public void insert(MonogCharacterDto dto) {
        MonogCharacter monogCharacter = CharacterMapper.INSTANCE.map(dto);
        mongodbRepository.save(monogCharacter);
        log.debug("Saved record {}", monogCharacter);
    }

}
