package com.oracle.project.layer2;

//import javax.persistence.Entity;
//import javax.persistence.Id;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Component
@jakarta.persistence.Entity

public class NewsPaper { //name of the table is same as the class
	
	@Id
	private int newsPaperId; 
	private String newsPaperName; 
	private int numberOfPages; 
	private float newsPaperCost;
	
	//Generate getters, setters and toString for the 4 variables
	
	public int getNewsPaperId() {
		return newsPaperId;
	}
	
	public void setNewsPaperId(int newsPaperId) {
		this.newsPaperId = newsPaperId;
	}
	public String getNewsPaperName() {
		return newsPaperName;
	}
	public void setNewsPaperName(String newsPaperName) {
		this.newsPaperName = newsPaperName;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public float getNewsPaperCost() {
		return newsPaperCost;
	}
	public void setNewsPaperCost(float newsPaperCost) {
		this.newsPaperCost = newsPaperCost;
	}
	
	@Override
	public String toString() {
		return "NewsPaper [newsPaperId=" + newsPaperId + ", newsPaperName=" + newsPaperName + ", numberOfPages="
				+ numberOfPages + ", newsPaperCost=" + newsPaperCost + "]";
	}
	
	
	
	
	
	
	
}