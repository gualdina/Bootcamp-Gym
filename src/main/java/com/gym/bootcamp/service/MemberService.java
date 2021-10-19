package com.gym.bootcamp.service;

import com.gym.bootcamp.model.Member;
import com.gym.bootcamp.repository.MemberRepository;
import com.gym.bootcamp.request.CreateMemberRQ;
import com.gym.bootcamp.request.UpdateMemberAgeRQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;


    //Find all members
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    //Find by Id
    public Member getMemberById(Long id) {
        return memberRepository.findById(id);
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

        //Update Age
        public Member updateMember(Long id, UpdateMemberAgeRQ updateMemberAgeRQ){
            Member memberToEdit = getMemberById(id);
            memberToEdit.setAge(updateMemberAgeRQ.getAge());

            return memberToEdit;
        }

        //Delete member by Id
        public void deleteById (Long id){
            this.getMemberById(id);
            memberRepository.deleteById(id);
        }

    }
}