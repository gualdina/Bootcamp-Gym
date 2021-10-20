package com.gym.bootcamp.request;

import com.gym.bootcamp.model.ClassesType;
import lombok.*;

import javax.persistence.Enumerated;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNewClassRQ {
    private String name;
    //@Enumerated abc123
    private ClassesType type;
}
