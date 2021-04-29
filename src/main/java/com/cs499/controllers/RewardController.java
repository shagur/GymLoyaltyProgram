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

import com.cs499.model.Reward;
import com.cs499.service.RewardService;

@RestController
@RequestMapping("/rewards")
public class RewardController {
	
    @Autowired
	private RewardService rewardService;
	
	@GetMapping("/all")
	public List<Reward> getAllRewards() {
		return rewardService.getAllRewards();
	}
	
	@GetMapping("/{id}")
	public Optional<Reward> getReward(@PathVariable Long id) {
		return rewardService.getReward(id);
	}
	
	@PostMapping("/add")
	public String addReward(@RequestBody final Reward reward) {
		rewardService.addReward(reward);
		String response = "{\"success\": true, \"message\": Topic has been added successfully.}";
		return response;
	}
	
	@PutMapping("/{id}")
	public String updateReward(@RequestBody Reward reward, @PathVariable Long id) {
		rewardService.updateReward(id, reward);
		String response = "{\"success\": true, \"message\": Topic has been updated successfully.}";
		return response;
	}
	
	@DeleteMapping("/{id}")
	public String deleteReward(@PathVariable Long id) {
		rewardService.deleteReward(id);
		String response = "{\"success\": true, \"message\": Topic has been deleted successfully.}";
		return response;
	}
	

}
