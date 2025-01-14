package com.database.integration.mongodb.service;

import com.database.integration.mongodb.dto.CharacterMessage;
import com.database.integration.mongodb.model.Character;
import com.database.integration.mongodb.repository.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class IntegrationServiceTest {

    @Mock
    private CharacterRepository repository;

    private IntegrationService service;

    @BeforeEach
    void setUp() {
        service = new IntegrationService(repository);
    }

    @Test
    void saveOrUpdate() {
        Long mysqlId = 10L;
        String name = "test name";
        String url = "http://test_url.com";
        String homeworld = "earth2";
        CharacterMessage dto = new CharacterMessage(mysqlId, name, url, homeworld);

        Character character = Character.builder()
                .id("test")
                .mysqlId(10L)
                .name("test name")
                .pictureUrl("http://test_url.com")
                .homeworld("earth")
                .creationDate(LocalDateTime.now())
                .build();

        when(repository.findByMysqlId(anyLong())).thenReturn(Optional.of(character));
        service.saveOrUpdate(dto);
        verify(repository, times(1)).save(character);
        assertNotNull(character.getUpdateDate());
        assertEquals(character.getHomeworld(), "earth2");
    }

}