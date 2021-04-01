package com.cs499.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs499.model.MembersActivity;

public interface MembersActivityRepo extends JpaRepository<MembersActivity, Long> {

}
