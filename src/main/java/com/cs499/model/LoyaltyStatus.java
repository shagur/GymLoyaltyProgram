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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Anis
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
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "loyalty_rewards",
            joinColumns = @JoinColumn(name = "loyaltyStatusID"),
            inverseJoinColumns = @JoinColumn(name = "rewardID"))
    private List<Reward> rewardsAvailable;
    
    private int currentTier;

    @OneToOne(
    	    orphanRemoval = true,
    	    cascade = CascadeType.ALL)
    private Member member;
    
    @Id
    @GeneratedValue
    private Long loyaltyStatusId;

    public LoyaltyStatus() {
        rewardsAvailable = new ArrayList<Reward>();
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
    
    public void addTotalPoints(int num) {
    	
    	int prevPoints = this.totalPoints;
        this.totalPoints += num;
        
        //auto redeem item when crossing 500 points and advance one tier
        if(prevPoints < 500 && totalPoints >= 500) {
        	
        	switch(currentTier) {
        	case BRONZE:
        		rewardsAvailable.add(new Reward("Keychain", "gym brandkeychain"));
        	case SILVER:
        		rewardsAvailable.add(new Reward("Super Bottle", "shaker bottle"));
        	case GOLD:
        		rewardsAvailable.add(new Reward("T Shirt", "gym brand shirt"));
        	case PLATINUM:
        		rewardsAvailable.add(new Reward("Nike Basketball", "basketball"));
        	case DIAMOND:
        		rewardsAvailable.add(new Reward("Super Whey Protein", "2 lb protein supplement"));
        	}
        
        
        totalPoints = 0;
        currentTier++;
        
        }//end if
        
        
        //if diamond prize is redeemed revert back to bronze
        if(currentTier > 4)
        	currentTier = 0;
        
    }
    
    public List<Reward> getRewardsAvailable() {
        return rewardsAvailable;
    }

    public int getCurrentTier() {
        return currentTier;
    }
    
    public void addRewardsAvailable() {
    	rewardsAvailable.add(new Reward("Super Bottle", "drinking bottle"));
    }
    
    public void redeemReward(int index) {
    	rewardsAvailable.remove(index);
    }

	@Override
	public String toString() {
		return "LoyaltyStatus [totalPoints=" + totalPoints + ", rewardsAvailable=" + rewardsAvailable + ", currentTier="
				+ currentTier + ", member=" + member + ", loyaltyStatusID=" + loyaltyStatusId + "]";
	}
        
}
