/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs499.model;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Anis
 *        
 */
@Entity
@Table(name="gyms")
public class Gym {
    
    @Id
    @GeneratedValue
    private Long gymId;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "gym_members",
            joinColumns = @JoinColumn(name = "gymId"),
            inverseJoinColumns = @JoinColumn(name = "memberId"))
    private List<Member> members;
    
    private String contactInformation;

    public Gym(String contactInformation) {
        this.members = new ArrayList<>();
        this.contactInformation = contactInformation;
    }

    public Gym() {
    	this.members = new ArrayList<>();
        this.contactInformation = "";
    }

    public void addMember(Member newMember) {
    	members.add(newMember);
    }

    public List<Member> getMembers() {
        return members;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

	@Override
	public String toString() {
		return "Gym [gymId=" + gymId + ", members=" + members + ", contactInformation=" + contactInformation + "]";
	}
            
}
