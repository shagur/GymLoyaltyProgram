/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs499.model;

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
    private String fName;
    private String lName;
    private String email;
    private String phoneNumber;
    
    @OneToOne
    private LoyaltyStatus loyaltyStatus;
    
    @Id
    @GeneratedValue
    private Long memberId;

    @ManyToOne
    private Gym gym;

    public Member(String username, String password, String fName, String lName, String email, String phoneNumber, Long uniqueId) {
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.memberId = uniqueId;
        loyaltyStatus = new LoyaltyStatus();
    }

    public Member() {
    	this.username = "";
        this.password = "";
        this.fName = "";
        this.lName = "";
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
        return fName;
    }
    
    public String getLastName() {
        return lName;
    }
    
    public String getFullName() {
        return fName + " " + lName;
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

    @Override
    public String toString() {
        return "GymMember{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + fName + " " + lName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", loyaltyStatus=" + loyaltyStatus +
                ", uniqueID=" + memberId +
                ", gym=" + gym +
                '}';
    }
}
