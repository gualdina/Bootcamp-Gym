package com.gym.bootcamp.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class GymSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String  id;
    private String name;
    private int area;

}
