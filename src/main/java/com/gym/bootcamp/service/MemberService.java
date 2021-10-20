package com.gym.bootcamp.service;

import com.gym.bootcamp.model.Member;
import com.gym.bootcamp.repository.MemberRepository;
import com.gym.bootcamp.request.CreateMemberRQ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MemberService {

    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //Find all members
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    //Find by Id
    public Member getMemberById(String id) {
        return memberRepository.findById(id).get();
    }

    //Find by Name
    public Member getMemberByName(String name) {
        List<Member> findAll = memberRepository.findAll();
        Member member;
        for (int i = 0; i < findAll.size(); i++) {
            if (findAll.get(i).getName() == name)
                return findAll.get(i);
        }
        return null;
    }

    //Create new member (List)
    public List<Member> createMembers(List<CreateMemberRQ> createMemberRQList) {
        List<Member> newMemberList = new ArrayList<>();
        Member newMember;
        for (CreateMemberRQ createMemberRQ : createMemberRQList) {
            newMember = Member.builder().name(createMemberRQ.getName()).age(createMemberRQ.getAge()).build();
            memberRepository.save(newMember);
            newMemberList.add(newMember);
        }
        return newMemberList;
    }

    //Update member's age
     public Member updateMember(String id, int age) {
        Member memberToUpdate = this.getMemberById(id);
        memberToUpdate.setAge(age);
        memberRepository.save(memberToUpdate);
        return memberToUpdate;
    }

    //Delete by id
    public void deleteById(String id) {
        this.getMemberById(id);
        memberRepository.deleteById(id);
    }
}