package com.gym.bootcamp.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGymSpaceNameRQ {
    private String name;
}
