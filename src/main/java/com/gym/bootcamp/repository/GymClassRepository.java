package com.gym.bootcamp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;

@Repository
public interface GymClassRepository extends MongoRepository<GymClass, Long>{
    }

}

