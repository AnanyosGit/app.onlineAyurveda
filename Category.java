package com.app.onlineAyurveda.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	private String categoryId;
	
	private String categoryName;
	public Category() {
		super();
	}
	public Category(String categoryId,String categoryName) {
		this.categoryId=categoryId;
		this.categoryName=categoryName;
		
	}
	
	public void setCategoryId(String id) {
		this.categoryId=id;
	}
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryName(String name) {
		this.categoryName=name;
	}
	public String getCategoryName() {
		return this.categoryName;
	}
	@Override 
	public String toString() {
		return "Category[categoryId="+this.categoryId+", categoryName="+this.categoryName+"]";
	}
	
	

}
