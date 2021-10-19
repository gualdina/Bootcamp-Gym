package com.gym.bootcamp.service;

import com.gym.bootcamp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    //
    public Member getMemberById(Long id){
        return memberRepository.findById(id);
}

}
