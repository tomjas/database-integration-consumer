package com.database.integration.mongodb.repository;

import com.database.integration.mongodb.model.MongoCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MongoCharacterRepository extends MongoRepository<MongoCharacter, String> {
    Optional<MongoCharacter> findByMysqlId(Long mysqlId);

    List<MongoCharacter> findByName(String name);
}
