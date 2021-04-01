package com.cs499.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs499.model.Reward;

public interface RewardRepo extends JpaRepository<Reward, Long> {

}
