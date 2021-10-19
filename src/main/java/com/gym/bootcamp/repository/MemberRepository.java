package com.gym.bootcamp.repository;

import com.gym.bootcamp.model.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Primary
@Repository
public interface MemberRepository extends MongoRepository<Member, Long> {

}
