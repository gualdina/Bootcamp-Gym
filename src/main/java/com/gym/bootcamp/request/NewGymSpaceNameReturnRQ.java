package com.gym.bootcamp.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewGymSpaceNameReturnRQ {
    private long Id;
    private String name;
    private int area;
}
