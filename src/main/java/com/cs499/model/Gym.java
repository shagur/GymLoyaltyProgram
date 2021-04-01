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
 * @author Anis, Dang
 *        
 */
@Entity
@Table(name="gyms")
public class Gym {
    
    @Id
    @GeneratedValue
    private Long gymID;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "gym_members",
            joinColumns = @JoinColumn(name = "gymID"),
            inverseJoinColumns = @JoinColumn(name = "memberID"))
    private List<Member> members;
    private Period contractPeriod;
    private String contactInformation;

    public Gym(List<Member> members, Period contractPeriod, String contactInformation) {
        this.members = new ArrayList<>();
        this.contractPeriod = contractPeriod;
        this.contactInformation = contactInformation;
    }

    public Gym() {
    	this.members = new ArrayList<>();
        this.contactInformation = "";
    }

    /** Add member to members
     *
     */
    public void addMember(Member newMember) {
    	members.add(newMember);
    }

    public List<Member> getMembers() {
        return members;
    }

    public Period getContractPeriod() {
        return contractPeriod;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void setContractPeriod(Period contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
    
    
}
