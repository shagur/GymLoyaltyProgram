package com.cs499.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs499.model.Gym;

public interface GymRepo extends JpaRepository<Gym, Long> {

}
