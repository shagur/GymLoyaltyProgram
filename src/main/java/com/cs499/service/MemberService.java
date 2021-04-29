package com.cs499.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs499.model.Member;
import com.cs499.repositories.MemberRepo;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepo memberRepo;
		
	public List<Member> getAllMembers() {
		return memberRepo.findAll();
	}

	public Member getMember(Long id) {
		return memberRepo.getOne(id);
	}

	public void addMember(Member member) {
		memberRepo.saveAndFlush(member);
	}

	public void updateMember(Long id, Member member) {
		memberRepo.save(member);
	}

	public void deleteMember(Long id) {
		memberRepo.deleteById(id);
	}

}
