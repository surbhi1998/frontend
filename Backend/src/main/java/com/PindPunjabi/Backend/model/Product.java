package com.PindPunjabi.Backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Product {
		
		@Id
		@GeneratedValue
		int productId;
		String productName;
		String productDesc;
		String categoryId; 
	    int	price;
		int quantity;
		@JoinColumn(name="categoryId",updatable=false,insertable=false,nullable=false)
		@ManyToOne
		Category category;
		
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		@Transient
		MultipartFile image;
	
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
			
		public MultipartFile getImage() {
			return image;
		}
		public void setImage(MultipartFile image) {
			this.image = image;
		}
	
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductDesc() {
			return productDesc;
		}
		public void setProductDesc(String productDesc) {
			this.productDesc = productDesc;
		}
			
		public String getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(String categoryId) {
			this.categoryId = categoryId;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		
					
		
		
		
}
