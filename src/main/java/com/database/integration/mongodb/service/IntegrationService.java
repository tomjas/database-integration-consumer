package com.database.integration.mongodb.service;


import com.database.integration.mongodb.dto.MongoCharacterDto;
import com.database.integration.mongodb.model.MongoCharacter;
import com.database.integration.mongodb.repository.MongoCharacterRepository;
import com.database.integration.mongodb.util.CharacterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class IntegrationService {

    private final MongoCharacterRepository mongodbRepository;

    @Transactional
    public void saveOrUpdate(MongoCharacterDto dto) {
        MongoCharacter character = CharacterMapper.INSTANCE.map(dto);
        Optional<MongoCharacter> optional = mongodbRepository.findByMysqlId(character.getMysqlId());
        if (optional.isPresent()) {
            update(optional.get(), dto);
        } else {
            mongodbRepository.save(character);
            log.debug("Saved record {}", character);
        }
    }

    public void update(MongoCharacter character, MongoCharacterDto dto) {
        character.setName(dto.name());
        character.setPictureUrl(dto.pictureUrl());
        character.setHomeworld(dto.homeworld());
        mongodbRepository.save(character);
        log.debug("Updated record {}", character);
    }

}
