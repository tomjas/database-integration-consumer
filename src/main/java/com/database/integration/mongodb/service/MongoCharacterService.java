package com.database.integration.mongodb.service;

import com.database.integration.mongodb.exception.NoSuchCharacterExcpetion;
import com.database.integration.mongodb.model.MongoCharacter;
import com.database.integration.mongodb.repository.MongoCharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MongoCharacterService {

    private final MongoCharacterRepository repository;

    public List<MongoCharacter> getCharacters() {
        return repository.findAll();
    }

    public List<MongoCharacter> getByName(String name) {
        return repository.findByName(name);
    }

    public MongoCharacter getById(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchCharacterExcpetion("No character with id " + id));
    }
}
