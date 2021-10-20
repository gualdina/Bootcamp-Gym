package com.gym.bootcamp.controller;

import com.gym.bootcamp.model.GymClass;
import com.gym.bootcamp.request.CreateNewClassRQ;
import com.gym.bootcamp.service.GymClassService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class GymClassController {
    GymClassService gymClassService;

    public GymClassController(GymClassService gymClassService) {
        this.gymClassService = gymClassService;
    }

    //Get all classes
    @GetMapping("/GymClasses")
    public List<GymClass> getGymClass() {
        return gymClassService.findAll();
    }

    //Get classes by id
    @GetMapping("/GymClasses/{id}")
    public GymClass getGymClassById(@PathVariable String id) {
        return gymClassService.getGymClassById(id);
    }

    //Get classes by name
    @GetMapping(value = "/GymClasses/{name}")
    public GymClass getGymClassByName(@PathVariable(value = "name") @Valid String name){
        return gymClassService.getGymClassByName(name);
    }

    //Create class
    @PostMapping(value = "/GymClass", consumes = "application/json")
    public List<GymClass> createGymClass(@RequestBody @Valid List<CreateNewClassRQ> createNewClassRQ) {
        return gymClassService.createGymClass(createNewClassRQ);
    }

    //Delete class
    @DeleteMapping(value = "/GymClass-delete/{id}")
    public void deleteById(@PathVariable(value = "id") String id) {
        gymClassService.deleteById(id);
    }
}
