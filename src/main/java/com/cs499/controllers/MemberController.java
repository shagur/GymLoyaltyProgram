package com.cs499.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs499.model.Gym;
import com.cs499.model.Member;
import com.cs499.repositories.MemberRepo;
import com.cs499.service.MemberService;

@RestController
@RequestMapping("/members") 
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/all")
	public List<Member> getAllMembers() {
		return memberService.getAllMembers();
	}
	
	@GetMapping("{id}")
	public Member getMember(@PathVariable Long id) {
		return memberService.getMember(id);
	}
	
	@PostMapping("/add")
	public String addMember(@RequestBody final Member member) {
		memberService.addMember(member);
		String response = "{\"success\": true, \"message\": Member has been updated successfully.}";
		return response;
	}
	
	@PutMapping("/{id}")
	public String updateMember(@RequestBody Member member, @PathVariable Long id) {
		memberService.updateMember(id, member);
		String response = "{\"success\": true, \"message\": Member has been updated successfully.}";
		return response;
	}
	
	@DeleteMapping("/{id}")
	public String deleteMember(@PathVariable Long id) {
		memberService.deleteMember(id);
		String response = "{\"success\": true, \"message\": Member has been deleted successfully.}";
		return response;
	}

}
