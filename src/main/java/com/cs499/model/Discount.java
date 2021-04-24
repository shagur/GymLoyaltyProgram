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
public class Discount extends Reward {

    private int discountAmount;
    private boolean claim;

    public Discount(String name, String desc, int discountAmount) {
        super(name, desc);
        this.discountAmount = discountAmount;
        claim = false;
    }

    public void claim() {
        claim = true;
    }

    public boolean isClaim() {
        return claim;
    }
    
    public int getDiscountAmount() {
        return discountAmount;
    }
}
