package com.gym.bootcamp.service;

import com.gym.bootcamp.model.GymSpace;
import com.gym.bootcamp.repository.GymSpaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymSpaceService {

    private final GymSpaceRepository gymSpaceRepository;

    public GymSpaceService(GymSpaceRepository gymSpaceRepository) {

        this.gymSpaceRepository = gymSpaceRepository;
    }

    //List of all gym spaces
    public List<GymSpace> findAll() {
        return gymSpaceRepository.findAll();
    }

    //Find space by name
    public GymSpace getGymSpaceByName(String name) {
        List<GymSpace> allGymSpaces = gymSpaceRepository.findAll();
        GymSpace gymSpace;
        for (int i = 0; i < allGymSpaces.size(); i++) {
            if (allGymSpaces.get(i).getName() == name)
                return allGymSpaces.get(i);
        }
        return null;
    }

    //Update space name
    public GymSpace updateGymSpace(String name) {
        GymSpace gymSpaceToUpdate = this.getGymSpaceByName(name);
        gymSpaceToUpdate.setName(name);
        gymSpaceRepository.save(gymSpaceToUpdate);
        return gymSpaceToUpdate;
    }
}

