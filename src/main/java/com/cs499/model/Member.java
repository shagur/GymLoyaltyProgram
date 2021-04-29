/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs499.model;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Anis
 *         
 */
@Entity
@Table(name = "members")
public class Member {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    
    @OneToOne(
    	    orphanRemoval = true,
    	    cascade = CascadeType.ALL)
    private LoyaltyStatus loyaltyStatus;
    
    @Id
    @GeneratedValue
    private Long memberId;

    @ManyToOne
    private Gym gym;

    public Member(String username, String password, String fName, String lName, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        loyaltyStatus = new LoyaltyStatus();
    }

    public Member() {
    	this.username = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phoneNumber = "";
        loyaltyStatus = new LoyaltyStatus();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Long getUniqueID() {
        return memberId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setGym(Gym gym) {
    	this.gym = gym;
    }
 
    public void addPoints(int points) {
    	loyaltyStatus.addTotalPoints(points);
    }

	@Override
    public String toString() {
        return "GymMember{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + firstName + " " + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", loyaltyStatus=" + loyaltyStatus +
                ", uniqueID=" + memberId +
                ", gym=" + gym +
                '}';
    }
}
