package com.database.integration.mongodb.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "characters")
@Builder
@Data
public class MongoCharacter {

    @Id
    private String id;

    @Field(name = "mysql_id")
    private Long mysqlId;

    @Field(name = "name")
    private String name;

    @Field(name = "pictureUrl")
    private String pictureUrl;

    @Field(name = "homeworld")
    private String homeworld;

    @Field(name = "creation_date")
    private LocalDateTime creationDate;

    @Field(name = "update_date")
    private LocalDateTime updateDate;
}
