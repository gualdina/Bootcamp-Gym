package com.gym.bootcamp.Controller;

import com.gym.bootcamp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
public class MemberController {
    @Autowired
    MemberService memberService;

    //Get all Members
    @GetMapping("/getMembers")
    public List<Member> getMembers() {
        return memberService.findAll();
    }

    //Get members by id
    @GetMapping("/getMembersById/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    //Create member
    @PostMapping(value = "/createMember", consumes = "application/json", produces = "application/json")
    public Member createMember(@RequestBody Member member) {
        Member newMember = Member.builder().name(member.getName()).build();
        memberService.save(newMember);
        return newMember;
    }

    //Update member
    @PutMappingvalue = "updateMembers/{id}", consumes = "application/json", produces = "application/json")
    public Member updateMember(@PathVariable(value = "id") Long id, @RequestBody Member member) {
        System.out.println(id);
        Optional<Member> memberToBeUpdated = memberService.findById(id);
        if (memberToBeUpdated.isPresent()) {
            memberToBeUpdated.get().setAge(member.getAge());
            memberService.save(memberToBeUpdated.get());
            return memberToBeUpdated.get();
        } else {
            ResponseEntity.badRequest().body("Member not found");
            return null;
        }
    }
        //Delete country
        @DeleteMapping(value = "/deleteMember{id}")
        public void deleteMember(@PathVariable(value = "id") Long id){
            memberService.deleteById(id);}

}