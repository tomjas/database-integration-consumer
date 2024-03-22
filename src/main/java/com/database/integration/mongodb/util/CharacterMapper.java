package com.database.integration.mongodb.util;

import com.database.integration.mongodb.dto.MongoCharacterDto;
import com.database.integration.mongodb.model.MongoCharacter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacterMapper {

    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", expression = "java(java.time.LocalDateTime.now())")
    MongoCharacter map(MongoCharacterDto dto);
}
