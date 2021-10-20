package com.gym.bootcamp.service;


import com.gym.bootcamp.model.GymClass;
import com.gym.bootcamp.repository.GymClassRepository;
import com.gym.bootcamp.request.CreateNewClassRQ;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GymClassService {

    private final GymClassRepository gymClassRepository;

    public GymClassService(GymClassRepository gymClassRepository) {
        this.gymClassRepository = gymClassRepository;
    }

    //Find all classes
    public List<GymClass> findAll() {
        return gymClassRepository.findAll();
    }

    //Find by Id
    public GymClass getGymClassById(String id) {
        return gymClassRepository.findById(id).get();
    }

    //Find by Name
    public GymClass getGymClassByName(String name) {
        List<GymClass> findAll = gymClassRepository.findAll();
        GymClass gymClass;
        for (int i = 0; i < findAll.size(); i++) {
            if (findAll.get(i).getName() == name)
                return findAll.get(i);
        }
        return null;
    }

    //Create new class (List)
    public List<GymClass> createGymClass(List<CreateNewClassRQ> createNewClassRQList) {
        List<GymClass> newClassList = new ArrayList<>();
        GymClass newClass;
        for (CreateNewClassRQ createNewClassRQ : createNewClassRQList) {
            newClass = GymClass.builder().name(createNewClassRQ.getName()).type(createNewClassRQ.getType()).build();
            gymClassRepository.save(newClass);
            newClassList.add(newClass);
        }
        return newClassList;
    }

    //Delete by Id
    public void deleteById(String id) {
        this.getGymClassById(id);
        gymClassRepository.deleteById(id);
    }


}