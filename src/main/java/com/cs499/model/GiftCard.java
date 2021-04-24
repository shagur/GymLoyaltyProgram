/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs499.model;

/**
 *
 * @author Dang
 */
public class GiftCard extends Reward {
	
    private int amount;
    private int giftcardId;
    
    public GiftCard(String name, String desc, int amount, int giftcardId) {
        super(name, desc);
        this.amount = amount;
        this.giftcardId = giftcardId;
    }   

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

	@Override
	public String toString() {
		return "GiftCard [amount=" + amount + ", giftcardId=" + giftcardId + "]";
	}
        
}
