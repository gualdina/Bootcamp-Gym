package com.gym.bootcamp.controller;

import com.gym.bootcamp.model.GymSpace;
import com.gym.bootcamp.service.GymSpaceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class GymSpaceController {
private final GymSpaceService gymSpaceService;
    public GymSpaceController(GymSpaceService gymSpaceService) {
        this.gymSpaceService = gymSpaceService;
    }
    //Get all spaces
    @GetMapping(value = "/space")
    public List<GymSpace> getGymSpaceList() {
        return gymSpaceService.findAll();
    }
  //

}
