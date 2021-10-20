package com.gym.bootcamp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private int age;
}