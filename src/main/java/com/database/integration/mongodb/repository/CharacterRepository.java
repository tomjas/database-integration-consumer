package com.database.integration.mongodb.repository;

import com.database.integration.mongodb.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends MongoRepository<Character, String> {
    Optional<Character> findByMysqlId(Long mysqlId);

    List<Character> findByName(String name);
}
