package com.gym.bootcamp.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Entity
public class GymClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;
    @Enumerated
    private ClassesType type;
}
