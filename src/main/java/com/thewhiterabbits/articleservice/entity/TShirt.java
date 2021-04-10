package com.thewhiterabbits.articleservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class TShirt {
    @Id
    private String id;
    private String color;
    private Map<String, Integer> material;
    private String size;

}
