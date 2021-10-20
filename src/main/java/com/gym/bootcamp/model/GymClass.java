package com.gym.bootcamp.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="Gymclass")
@Entity

public class GymClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private GymClassType gymclassType;
    private String name;

    @OneToMany(mappedBy = "gymclass")
    private List<GymClass> gymClassList;

}
