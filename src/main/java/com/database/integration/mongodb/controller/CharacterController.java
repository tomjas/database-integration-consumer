package com.database.integration.mongodb.controller;

import com.database.integration.mongodb.model.Character;
import com.database.integration.mongodb.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1.0")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService service;

    @GetMapping(value = "/characters")
    public List<Character> getCharacters(@RequestParam(required = false) String name) {
        return service.getCharacters(name);
    }

    @GetMapping(value = "/characters/{id}")
    public Character getById(@PathVariable String id) {
        return service.getById(id);
    }
}
