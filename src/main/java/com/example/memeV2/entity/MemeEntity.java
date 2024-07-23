package com.example.memeV2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="memes")
@NoArgsConstructor
public class MemeEntity {

    @Id
    private String id;
    private String name;
    private String url;
    private String caption;



}
