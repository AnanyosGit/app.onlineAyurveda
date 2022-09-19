package com.app.onlineAyurveda.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.app.onlineAyurveda.entity.Category;

@Entity
public class Medicine {
	//instance variables
	
	@Id
	private String medicineId;
	
	private String medicineName;
	private float medicineCost;
	private LocalDate mfd;
	private LocalDate expiryDate;
	private String companyName;
	
	
	//one to one mapping between medicine and category entities
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Category_ID")
	private Category category;
	
	public Medicine() {
		super();
	}
	public Medicine(String id,String name,float cost, LocalDate mfd, LocalDate expdate, String company) {
		this.medicineId=id;
		this.medicineName=name;
		this.medicineCost=cost;
		this.mfd=mfd;
		this.expiryDate=expdate;
		this.companyName=company;
		this.category=category;
	}
	
	public void setMedicineId(String id) {
		this.medicineId=id;
	}
	public String getMedicineId() {
		return this.medicineId;
	}
	public void setMedicineName(String name) {
		this.medicineName=name;
	}
	public String getMedicineName() {
		return this.medicineName;
	}
	public void setMedicineCost(float cost) {
		this.medicineCost=cost;
	}
	public float getMedicineCost() {
		return this.medicineCost;
	}
	public void setMfd(LocalDate mfd) {
		this.mfd=mfd;
	}
	public LocalDate getMfd() {
		return this.mfd;
	}
	public void setExpiryDate(LocalDate expiry) {
		this.expiryDate=expiry;
	}
	public LocalDate getExpiryDate() {
		return this.expiryDate;
	}
	public void setCompanyName(String company) {
		this.companyName=company;
	}
	public String getCompanyName() {
		return this.companyName;
	}
	public void setCategory(Category category) {
		this.category=category;
	}
	public Category getCategory() {
		return this.category;
	}
	
	@Override 
	public String toString() {
		return "Medicine [medicineId="+this.medicineId+", medicineName="+this.medicineName+", medicineCost="+this.medicineCost+", mfd="+this.mfd+", expiryDate="+this.expiryDate+", companyName="+this.companyName+"]";
	}

}

