package com.gym.bootcamp.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.security.SecureRandom;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class GymClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    @Enumerated
    private ClassesType type;
}
