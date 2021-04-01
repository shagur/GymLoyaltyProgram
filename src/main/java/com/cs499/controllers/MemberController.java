package com.cs499.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs499.model.Member;
import com.cs499.repositories.MemberRepo;

@RestController
@RequestMapping("/members") 
public class MemberController {
	
	@Autowired
	private MemberRepo memberRepo;
	
	@GetMapping("/all")
	public List<Member> list() {
		return memberRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Member get(@PathVariable Long id) {
		return memberRepo.getOne(id);
	}
	
	@PostMapping
	public Member create(@RequestBody final Member member) {
		return memberRepo.saveAndFlush(member);
	}

}
