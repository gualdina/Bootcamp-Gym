package com.gym.bootcamp.controller;

import com.gym.bootcamp.exception.GymSpaceNotFoundException;
import com.gym.bootcamp.model.GymSpace;
import com.gym.bootcamp.model.Member;
import com.gym.bootcamp.request.CreateMemberRQ;
import com.gym.bootcamp.request.UpdateGymSpaceNameRQ;
import com.gym.bootcamp.request.UpdateMemberAgeRQ;
import com.gym.bootcamp.service.GymSpaceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class GymSpaceController {
    private final GymSpaceService gymSpaceService;

    public GymSpaceController(GymSpaceService gymSpaceService) {
        this.gymSpaceService = gymSpaceService;
    }

    //Get all spaces
    @GetMapping("/GymSpaces")
    public List<GymSpace> getMembers() {
        return gymSpaceService.findAll();
    }

    //Get by name
    @GetMapping(value = "/GymSpaces/{name}")
    public GymSpace getGymSpaceByName(@PathVariable(value = "name") @Valid String name) throws GymSpaceNotFoundException {
        return gymSpaceService.getGymSpaceByName(name);
    }

    //Update member
    @PutMapping(value = "/GymSpaces-update/{id}", consumes = "application/json", produces = "application/json")
    public GymSpace updateSpaceName(@PathVariable(value = "id") String id, @RequestBody UpdateGymSpaceNameRQ updateGymSpaceNameRQ) {
        return gymSpaceService.updateGymSpace(updateGymSpaceNameRQ.getName());
    }

}