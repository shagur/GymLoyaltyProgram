package com.cs499.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs499.model.LoyaltyStatus;
import com.cs499.repositories.LoyaltyStatusRepo;

@RestController
@RequestMapping("/loyaltystatuses")
public class LoyaltyStatusController {
	
	@Autowired
	private LoyaltyStatusRepo loyaltyStatusRepo;
	
	@GetMapping("/all")
	public List<LoyaltyStatus> list() {
		return loyaltyStatusRepo.findAll();
	}
	
	@GetMapping("{id}")
	public LoyaltyStatus get(@PathVariable Long id) {
		return loyaltyStatusRepo.getOne(id);
	}
	
	@PostMapping
	public LoyaltyStatus create(@RequestBody final LoyaltyStatus loyaltyStatus) {
		return loyaltyStatusRepo.saveAndFlush(loyaltyStatus);
	}

}
