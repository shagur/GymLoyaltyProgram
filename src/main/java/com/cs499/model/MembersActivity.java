/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs499.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Dang
 */
@Entity
@Table(name="membersActivity")
public class MembersActivity {
    private int consecutiveDays;
    
    @Id
    @GeneratedValue
    private Long loyaltyStatus;
    
    @OneToOne
    private LoyaltyStatus loyalty;
}
