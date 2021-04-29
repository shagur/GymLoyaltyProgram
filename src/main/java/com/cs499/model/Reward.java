/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs499.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Anis
 */
@Entity
@Table(name="reward")
public class Reward {
    
	private String name;
	private String description;
    
    @Id
    @GeneratedValue
    private Long rewardId;
      
    public Reward(String name, String desc) {
        this.name = name;
        this.description = desc;
    }
        
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public Reward() {
    	this.name = "";
    	this.description = "";
    }

	@Override
	public String toString() {
		return "Reward [name=" + name + ", description=" + description + ", rewardId=" + rewardId + "]";
	}
        
}
