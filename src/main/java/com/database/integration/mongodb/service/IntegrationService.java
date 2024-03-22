package com.database.integration.mongodb.service;


import com.database.integration.mongodb.dto.MongoCharacterDto;
import com.database.integration.mongodb.model.MongoCharacter;
import com.database.integration.mongodb.repository.MongoCharacterRepository;
import com.database.integration.mongodb.util.CharacterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class IntegrationService {

    private final MongoCharacterRepository repository;

    @Transactional
    public void saveOrUpdate(MongoCharacterDto dto) {
        Optional<MongoCharacter> optional = repository.findByMysqlId(dto.mysqlId());
        MongoCharacter character = optional.map(mongoCharacter -> update(mongoCharacter, dto))
                .orElseGet(() -> CharacterMapper.INSTANCE.map(dto));
        repository.save(character);
        log.debug("Saved record {}", character);
    }

    private MongoCharacter update(MongoCharacter character, MongoCharacterDto dto) {
        character.setName(dto.name());
        character.setPictureUrl(dto.pictureUrl());
        character.setHomeworld(dto.homeworld());
        character.setUpdateDate(LocalDateTime.now());
        return character;
    }

}
