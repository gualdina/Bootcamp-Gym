package com.gym.bootcamp.request;

import com.gym.bootcamp.model.ClassesType;

import javax.persistence.Enumerated;

public class CreateNewClassRQ {
    private String name;
    @Enumerated
    private ClassesType type;

}
