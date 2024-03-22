package com.database.integration.mongodb.dto;

import lombok.Builder;

@Builder
public record CharacterMessage(Long mysqlId, String name, String pictureUrl, String homeworld) {
}
