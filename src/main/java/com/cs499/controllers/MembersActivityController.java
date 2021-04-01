package com.cs499.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs499.model.MembersActivity;
import com.cs499.repositories.MembersActivityRepo;

@RestController
@RequestMapping("/membersactivity")
public class MembersActivityController {
	
	@Autowired
	private MembersActivityRepo membersActivityRepo;
	
	@GetMapping("/all")
	public List<MembersActivity> list() {
		return membersActivityRepo.findAll();
	}
	
	@GetMapping("{id}")
	public MembersActivity get(@PathVariable Long id) {
		return membersActivityRepo.getOne(id);
	}
	
	@PostMapping
	public MembersActivity create(@RequestBody final MembersActivity membersActivity) {
		return membersActivityRepo.saveAndFlush(membersActivity);
	}

}
