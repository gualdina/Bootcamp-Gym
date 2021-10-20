package com.gym.bootcamp.Controller;

import com.gym.bootcamp.model.Member;
import com.gym.bootcamp.request.CreateMemberRQ;
import com.gym.bootcamp.request.UpdateMemberAgeRQ;
import com.gym.bootcamp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //Get all Members
    @GetMapping("/Members")
    public List<Member> getMembers() {
        return memberService.findAll();
    }

    //Get members by id
    @GetMapping("/Members/{id}")
    public Member getMemberById(@PathVariable String id) {
        return memberService.getMemberById(id);
    }

    //Create member
    @PostMapping(value = "/Member", consumes = "application/json", produces = "application/json")
    public List<Member> createMembers(@RequestBody @Valid List<CreateMemberRQ> createMemberRQ) {
        return memberService.createMembers(createMemberRQ);
    }

    //Update member
    @PutMapping (value = "/Member-update/{id}", consumes = "application/json", produces = "application/json")
    public Member updateMember(@PathVariable(value = "id") String id, @RequestBody UpdateMemberAgeRQ updateMemberAgeRQ) {
        System.out.println(id);
        Optional<Member> memberToBeUpdated = Optional.ofNullable(memberService.getMemberById(id));
        if (memberToBeUpdated.isPresent()) {
            memberToBeUpdated.setAge(updateMemberAgeRQ.getAge());
            memberService.updateMember(memberToBeUpdated.get());
            return memberToBeUpdated.get();
        } else {
            ResponseEntity.badRequest().body("Member not found");
            return null;
        }
    }
        //Delete member
        @DeleteMapping(value = "/Member-delete/{id}")
        public void deleteById(@PathVariable(value = "id") String id){
            memberService.deleteById(id);}

}