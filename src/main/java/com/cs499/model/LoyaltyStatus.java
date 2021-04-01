/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs499.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Dang
 */
@Entity
@Table(name = "loyaltystatus")
public class LoyaltyStatus {

    private int totalPoints;
    private static final int BRONZE = 0;
    private static final int SILVER = 1;
    private static final int GOLD = 2;
    private static final int PLATINUM = 3;
    private static final int DIAMOND = 4;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "loyalty_rewards",
            joinColumns = @JoinColumn(name = "loyaltyStatusID"),
            inverseJoinColumns = @JoinColumn(name = "rewardID"))
    private List<Reward> rewardsAvailable;
    private int currentTier;

    @OneToOne
    private MembersActivity memberActivity;

    @OneToOne
    private Member member;
    
    @Id
    @GeneratedValue
    private Long loyaltyStatusID;

    public LoyaltyStatus() {
        rewardsAvailable = new ArrayList<Reward>();
        memberActivity = new MembersActivity();
        totalPoints = 0;
        currentTier = BRONZE;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setCurrentTier(int currentTier) {
        this.currentTier = currentTier;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public List<Reward> getRewardsAvailable() {
        return rewardsAvailable;
    }

    public int getCurrentTier() {
        return currentTier;
    }
}
