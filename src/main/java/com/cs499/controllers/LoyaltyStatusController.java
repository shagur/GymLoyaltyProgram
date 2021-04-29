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

import com.cs499.model.LoyaltyStatus;
import com.cs499.service.LoyaltyStatusService;

@RestController
@RequestMapping("/loyaltystatuses")
public class LoyaltyStatusController {
	
	@Autowired
	private LoyaltyStatusService loyaltyStatusService;
	
	@GetMapping("/all")
	public List<LoyaltyStatus> getAllLoyaltyStatus() {
		return loyaltyStatusService.getAllLoyaltyStatus();
	}
	
	@GetMapping("/{id}")
	public Optional<LoyaltyStatus> getLoyaltyStatus(@PathVariable Long id) {
		return loyaltyStatusService.getLoyaltyStatus(id);
	}
	
	@PostMapping
	public String addLoyaltyStatus(@RequestBody final LoyaltyStatus loyaltyStatus) {
		loyaltyStatusService.addLoyaltyStatus(loyaltyStatus);
		String response = "{\"success\": true, \"message\": Topic has been updated successfully.}";
		return response;
	}
	
	@PutMapping("/{id}")
	public String updateLoyaltyStatus(@RequestBody LoyaltyStatus loyaltyStatus, @PathVariable Long id) {
		loyaltyStatusService.updateLoyaltyStatus(id, loyaltyStatus);
		String response = "{\"success\": true, \"message\": Topic has been updated successfully.}";
		return response;
	}
	
	@DeleteMapping("/{id}")
	public String deleteLoyaltyStatus(@PathVariable Long id) {
		loyaltyStatusService.deleteLoyaltyStatus(id);
		String response = "{\"success\": true, \"message\": Topic has been deleted successfully.}";
		return response;
	}
	

}
