package com.gym.bootcamp.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewGymSpaceNameReturnRQ {
    private long Id;
    private String name;
    private int area;
}
