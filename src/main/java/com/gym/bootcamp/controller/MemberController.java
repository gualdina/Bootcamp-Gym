package com.gym.bootcamp.controller;

import com.gym.bootcamp.exception.NameNotFoundException;
import com.gym.bootcamp.model.Member;
import com.gym.bootcamp.request.CreateMemberRQ;
import com.gym.bootcamp.request.UpdateMemberAgeRQ;
import com.gym.bootcamp.service.MemberService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //Get all members
    @GetMapping("/Members")
    public List<Member> getMembers() {
        return memberService.findAll();
    }

    //Get members by id
    @GetMapping("/Members/{id}")
    public Member getMemberById(@PathVariable String id) {
        return memberService.getMemberById(id);
    }

    //Get member by name
    @GetMapping(value = "/Members/{name}")
    public Member getMemberByName(@PathVariable(value = "name") @Valid String name) throws NameNotFoundException{
        return memberService.getMemberByName(name);
    }

    //Create member
    @PostMapping(value = "/Members", consumes = "application/json", produces = "application/json")
    public List<Member> createMembers(@RequestBody @Valid List<CreateMemberRQ> createMemberRQ) {
        return memberService.createMembers(createMemberRQ);
    }

    //Update member
    @PutMapping(value = "/Members-update/{id}", consumes = "application/json", produces = "application/json")
    public Member updateMemberAge(@PathVariable(value = "id") String id, @RequestBody UpdateMemberAgeRQ updateMemberAgeRQ) {
        return memberService.updateMember(id,updateMemberAgeRQ.getAge());
    }

    //Delete member
    @DeleteMapping(value = "/Members-delete/{id}")
    public void deleteById(@PathVariable(value = "id") String id) {
        memberService.deleteById(id);
    }

}