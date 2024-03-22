package com.database.integration.mongodb.controller;

import com.database.integration.mongodb.model.Character;
import com.database.integration.mongodb.service.CharacterService;
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

    private final CharacterService service;

    @GetMapping(value = "/characters")
    public List<Character> getCharacters() {
        return service.getCharacters();
    }

    @GetMapping(value = "/characters/name/{name}")
    public List<Character> getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @GetMapping(value = "/characters/id/{id}")
    public Character getById(@PathVariable String id) {
        return service.getById(id);
    }
}
