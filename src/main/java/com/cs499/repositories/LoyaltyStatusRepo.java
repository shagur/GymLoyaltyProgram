package com.cs499.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs499.model.LoyaltyStatus;

public interface LoyaltyStatusRepo extends JpaRepository<LoyaltyStatus, Long> {

}
