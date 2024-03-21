package com.database.integration.mongodb.util;

import com.database.integration.mongodb.dto.MonogCharacterDto;
import com.database.integration.mongodb.model.MonogCharacter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacterMapper {

    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", expression = "java(java.time.LocalDateTime.now())")
    MonogCharacter map(MonogCharacterDto dto);
}
