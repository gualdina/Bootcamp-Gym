package com.gym.bootcamp.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMemberRQ {
    private String name;
    private int age;
}
