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
    private int giftcardID;
    
    public GiftCard(String name, int amount, int giftcardID) {
        super(name);
        this.amount = amount;
        this.giftcardID = giftcardID;
    }   

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
