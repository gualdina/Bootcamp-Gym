package com.gym.bootcamp.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class GymClass {
    @Id
    private String id;
    private String name;
    private ClassesType type;
}
