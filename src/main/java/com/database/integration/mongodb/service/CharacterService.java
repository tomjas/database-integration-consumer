package com.database.integration.mongodb.service;

import com.database.integration.mongodb.exception.NoSuchCharacterExcpetion;
import com.database.integration.mongodb.model.Character;
import com.database.integration.mongodb.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CharacterService {

    private final CharacterRepository repository;

    public List<Character> getCharacters(String name) {
        if (StringUtils.isNotBlank(name)) {
            return getByName(name);
        }
        return repository.findAll();
    }

    public List<Character> getByName(String name) {
        return repository.findByName(name);
    }

    public Character getById(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchCharacterExcpetion("No character with id " + id));
    }
}
