package com.cs499.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs499.model.Member;

public interface MemberRepo extends JpaRepository<Member, Long> {

}
