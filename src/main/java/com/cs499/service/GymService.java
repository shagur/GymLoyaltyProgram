package com.cs499.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs499.model.Gym;
import com.cs499.repositories.GymRepo;

@Service
public class GymService {
	
	@Autowired
	private GymRepo gymRepo;
		
	public List<Gym> getAllGyms() {
		return gymRepo.findAll();
	}

	public Optional<Gym> getGym(Long id) {
		return gymRepo.findById(id);
	}

	public void addGym(Gym gym) {
		gymRepo.saveAndFlush(gym);
	}

	public void updateGym(Long id, Gym gym) {
		gymRepo.save(gym);
	}

	public void deleteGym(Long id) {
		gymRepo.deleteById(id);
	}
	
}
