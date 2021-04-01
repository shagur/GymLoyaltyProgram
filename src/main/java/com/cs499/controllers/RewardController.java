package com.cs499.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs499.model.Reward;
import com.cs499.repositories.RewardRepo;

@RestController
@RequestMapping("/rewards")
public class RewardController {
	
	@Autowired
	private RewardRepo rewardRepo;
	
	@GetMapping("/all")
	public List<Reward> list() {
		return rewardRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Reward get(@PathVariable Long id) {
		return rewardRepo.getOne(id);
	}
	
	@PostMapping
	public Reward create(@RequestBody final Reward reward) {
		return rewardRepo.saveAndFlush(reward);
	}

}
