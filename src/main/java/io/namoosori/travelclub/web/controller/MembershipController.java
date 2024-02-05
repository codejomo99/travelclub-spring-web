package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.web.aggregate.club.Membership;
import io.namoosori.travelclub.web.service.MembershipService;
import io.namoosori.travelclub.web.service.logic.MembershipServiceLogic;
import io.namoosori.travelclub.web.service.sdo.MembershipCdo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    private MembershipService membershipService;

    public MembershipController(MembershipService membershipService){
        this.membershipService = membershipService;
    }

    @PostMapping
    public String register(@RequestBody MembershipCdo membershipCdo){
        return membershipService.registerMembership(membershipCdo);
    }

    @GetMapping("/{membershipId}")
    public Membership findMembership(@PathVariable String membershipId){
        return membershipService.findMembership(membershipId);
    }

    @GetMapping("/{clubId}")
    public Membership findMembershipByClubIdAndMemberId(@PathVariable String clubId, String memberId){
        return membershipService.findMembershipByClubIdAndMemberId(clubId,memberId);
    }

    @GetMapping
    public Membership find(@RequestParam String clubId, @RequestParam String memberEmail){
        return membershipService.findMembershipByClubIdAndMemberEmail(clubId,memberEmail);
    }


}
