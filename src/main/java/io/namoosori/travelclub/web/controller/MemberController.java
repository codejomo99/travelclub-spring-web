package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.web.aggregate.club.CommunityMember;
import io.namoosori.travelclub.web.service.MemberService;
import io.namoosori.travelclub.web.service.sdo.MemberCdo;
import io.namoosori.travelclub.web.shared.NameValueList;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping
    public String register(@RequestBody MemberCdo memberCdo){
        return memberService.registerMember(memberCdo);
    }

    @GetMapping("/{memberId}")
    public CommunityMember find(@PathVariable String memberId){
        return memberService.findMemberById(memberId);
    }

    @GetMapping
    public CommunityMember findByEmail(@RequestParam String email){
        return memberService.findMemberByEmail(email);
    }

    @GetMapping("/all")
    public List<CommunityMember> findAll(){
        return  memberService.findAll();
    }

    @GetMapping("/name")
    public List<CommunityMember> findName(@RequestParam String name){
        return memberService.findMembersByName(name);
    }

    @PutMapping("/{memberId}")
    public void modifyMember(@PathVariable String memberId, @RequestBody NameValueList nameValueList){
        memberService.modifyMember(memberId,nameValueList);
    }

    @DeleteMapping("/{memberId}")
    public void delete(@PathVariable String memberId){
        memberService.removeMember(memberId);
    }

}
