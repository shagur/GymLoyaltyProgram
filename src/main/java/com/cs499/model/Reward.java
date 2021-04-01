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
import javax.persistence.Table;

/**
 *
 * @author Dang
 */
@Entity
@Table(name="reward")
public class Reward {
    
    @ManyToOne
    private LoyaltyStatus loyalty;
    
    @Id
    @GeneratedValue
    private Long rewardID;
    private String name;
    
    public Reward(String name) {
        this.name = name;
    }

    public Reward() {

    }
}
