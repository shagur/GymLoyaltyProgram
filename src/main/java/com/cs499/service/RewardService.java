package com.cs499.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs499.model.Reward;
import com.cs499.repositories.RewardRepo;

@Service
public class RewardService {
	
	@Autowired
	private RewardRepo rewardRepo;
		
	public List<Reward> getAllRewards() {
		return rewardRepo.findAll();
	}

	public Optional<Reward> getReward(Long id) {
		return rewardRepo.findById(id);
	}

	public void addReward(Reward reward) {
		rewardRepo.saveAndFlush(reward);
	}

	public void updateReward(Long id, Reward reward) {
		rewardRepo.save(reward);
	}

	public void deleteReward(Long id) {
		rewardRepo.deleteById(id);
	}

}
