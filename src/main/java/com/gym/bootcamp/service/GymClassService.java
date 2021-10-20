package com.gym.bootcamp.service;

import com.gym.bootcamp.repository.GymClassRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service

public class GymClassService<GymClass> {
   private final GymClassRepository gymClassRepository;

   public GymClassService(GymClassRepository gymClassRepository) {
      this.gymClassRepository = gymClassRepository;
   }
   public List<GymClass> allGymClasses(){return gymClassRepository.findAll();}
   public GymClass findById(Long id){
      return gymClassRepository.findById(id);

   }
   public GymClass getGymClassByName(String name) {
      List<GymClass> allGymClass = gymClassRepository.findAll();
      GymClass gymClass;
      for(int i = 0; i < allGymClass.size(); i++){
         if(allGymClass.get(i).getName() == name)
            return allGymClass.get(i);
      }
      return null;
   }
   public GymClassService
   public GymClass addCustomer(GymClass customerRQ) {
      Object gymclassRQ;
      String firstName = gymclassRQ.getFirstName();
      String lastName = gymclassRQ.getLastName();
      int phoneNumber = gymclassRQ.getPhoneNumber();
      String city = gymclassRQ.getCity();
      String address = gymclass.getAddress();
      GymClass gymclass = GymClass
              .builder()
              .firstName(firstName)
              .lastName(lastName)
              .phoneNumber(phoneNumber)
      return gymClassRepository.save(gymclass);
   }
}
//Delete gymclass
@DeleteMapping(value= "deleMember{id}")
public void deleteMember(@PathVariable(value ="id") Long id){

}
