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
public class GymSpace {
    @Id
    private String  id;
    private String name;
    private int area;

}
