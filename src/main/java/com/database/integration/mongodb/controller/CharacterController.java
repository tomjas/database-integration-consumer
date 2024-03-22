package com.database.integration.mongodb.controller;

import com.database.integration.mongodb.model.MongoCharacter;
import com.database.integration.mongodb.service.MongoCharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1.0")
@RequiredArgsConstructor
public class CharacterController {

    private final MongoCharacterService service;

    @GetMapping(value = "/characters")
    public List<MongoCharacter> getCharacters() {
        return service.getCharacters();
    }

    @GetMapping(value = "/characters/name/{name}")
    public List<MongoCharacter> getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @GetMapping(value = "/characters/id/{id}")
    public MongoCharacter getById(@PathVariable String id) {
        return service.getById(id);
    }
}
