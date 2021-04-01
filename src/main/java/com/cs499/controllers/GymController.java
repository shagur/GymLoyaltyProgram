package com.cs499.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs499.model.Gym;
import com.cs499.repositories.GymRepo;

@RestController
@RequestMapping("/gyms")
public class GymController {
	
	@Autowired
	private GymRepo gymRepo;
	
	@GetMapping("/all")
	public List<Gym> list() {
		return gymRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Gym get(@PathVariable Long id) {
		return gymRepo.getOne(id);
	}
	
	@PostMapping
	public Gym create(@RequestBody final Gym gym) {
		return gymRepo.saveAndFlush(gym);
	}

}
