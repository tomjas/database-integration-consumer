package com.database.integration.mongodb.service;


import com.database.integration.mongodb.dto.CharacterMessage;
import com.database.integration.mongodb.model.Character;
import com.database.integration.mongodb.repository.CharacterRepository;
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

    private final CharacterRepository repository;

    @Transactional
    public void saveOrUpdate(CharacterMessage dto) {
        Optional<Character> optional = repository.findByMysqlId(dto.mysqlId());
        Character character = optional.map(mongoCharacter -> update(mongoCharacter, dto))
                .orElseGet(() -> CharacterMapper.INSTANCE.convertMessageToDocument(dto));
        repository.save(character);
        log.debug("Saved record {}", character);
    }

    private Character update(Character character, CharacterMessage dto) {
        character.setName(dto.name());
        character.setPictureUrl(dto.pictureUrl());
        character.setHomeworld(dto.homeworld());
        character.setUpdateDate(LocalDateTime.now());
        return character;
    }

}
