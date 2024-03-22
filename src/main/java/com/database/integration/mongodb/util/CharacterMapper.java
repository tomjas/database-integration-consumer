package com.database.integration.mongodb.util;

import com.database.integration.mongodb.dto.CharacterMessage;
import com.database.integration.mongodb.model.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacterMapper {

    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", expression = "java(java.time.LocalDateTime.now())")
    Character convertMessageToDocument(CharacterMessage dto);
}
