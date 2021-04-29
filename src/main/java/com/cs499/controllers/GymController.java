package com.cs499.controllers;

import java.util.List;
import java.util.Optional;

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
import com.cs499.service.GymService;

@RestController
@RequestMapping("/gyms")
public class GymController {
	
    @Autowired
	private GymService gymService;
	
	@GetMapping("/all")
	public List<Gym> getAllGyms() {
		return gymService.getAllGyms();
	}
	
	@GetMapping("/{id}")
	public Optional<Gym> getGym(@PathVariable Long id) {
		return gymService.getGym(id);
	}
	
	@PostMapping("/add")
	public String addGym(@RequestBody final Gym gym) {
		gymService.addGym(gym);
		String response = "{\"success\": true, \"message\": Topic has been added successfully.}";
		return response;
	}
	
	@PutMapping("/{id}")
	public String updateGym(@RequestBody Gym gym, @PathVariable Long id) {
		gymService.updateGym(id, gym);
		String response = "{\"success\": true, \"message\": Topic has been updated successfully.}";
		return response;
	}
	
	@DeleteMapping("/{id}")
	public String deleteGym(@PathVariable Long id) {
		gymService.deleteGym(id);
		String response = "{\"success\": true, \"message\": Topic has been deleted successfully.}";
		return response;
	}
	
}
