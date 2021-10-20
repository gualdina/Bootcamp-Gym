package com.gym.bootcamp.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateGymSpaceNameRQ {
    private String name;
}
