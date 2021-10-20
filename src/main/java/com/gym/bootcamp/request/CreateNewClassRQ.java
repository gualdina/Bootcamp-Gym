package com.gym.bootcamp.request;

import com.gym.bootcamp.model.ClassesType;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewClassRQ {
    private String name;
    private ClassesType type;
}
