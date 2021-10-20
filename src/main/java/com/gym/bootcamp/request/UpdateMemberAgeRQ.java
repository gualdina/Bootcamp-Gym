package com.gym.bootcamp.request;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberAgeRQ {
    private int age;
}
