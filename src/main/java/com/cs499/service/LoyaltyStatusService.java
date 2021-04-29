package com.cs499.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs499.model.LoyaltyStatus;
import com.cs499.repositories.LoyaltyStatusRepo;

@Service
public class LoyaltyStatusService {
	
	@Autowired
	private LoyaltyStatusRepo loyaltyStatusRepo;
		
	public List<LoyaltyStatus> getAllLoyaltyStatus() {
		return loyaltyStatusRepo.findAll();
	}

	public LoyaltyStatus getLoyaltyStatus(Long id) {
		return loyaltyStatusRepo.getOne(id);
	}

	public void addLoyaltyStatus(LoyaltyStatus loyaltyStatus) {
		loyaltyStatusRepo.saveAndFlush(loyaltyStatus);
	}

	public void updateLoyaltyStatus(Long id, LoyaltyStatus loyaltyStatus) {
		loyaltyStatusRepo.save(loyaltyStatus);
	}

	public void deleteLoyaltyStatus(Long id) {
		loyaltyStatusRepo.deleteById(id);
	}
	
}
