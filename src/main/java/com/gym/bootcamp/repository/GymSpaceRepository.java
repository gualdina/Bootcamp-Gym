package com.gym.bootcamp.repository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Primary
@Repository
public interface GymSpaceRepository extends MongoRepository<Long,ID> {
}
