package com.PindPunjabi.Backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
 @Table

 public class Deal {

	 	@Id
	 	@GeneratedValue
	 	
	 	int DealId;
	 	String DealName;
	 	Double Discount;
	 	
	 	Date StartDate;
	 	public int getDealId() {
			return DealId;
		}
		public void setDealId(int dealId) {
			DealId = dealId;
		}
		public String getDealName() {
			return DealName;
		}
		public void setDealName(String dealName) {
			DealName = dealName;
		}
		public Double getDiscount() {
			return Discount;
		}
		public void setDiscount(Double discount) {
			Discount = discount;
		}
		public Date getStartDate() {
			return StartDate;
		}
		public void setStartDate(Date startDate) {
			StartDate = startDate;
		}
		public Date getExpiryDate() {
			return ExpiryDate;
		}
		public void setExpiryDate(Date expiryDate) {
			ExpiryDate = expiryDate;
		}
		Date ExpiryDate;
	 	
	 
	 
	 
}
