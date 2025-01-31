package com.fastfood.restaurants.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderid;
	int productId;
	int productPrice;
	String customerName;
	String customerPhone;
	
	
	
	
	
	
	
	
	 public int getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}
	public int getOrderd() {
		return orderid;
	}
	public void setOrderd(int orderd) {
		this.orderid = orderd;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCustomeName() {
		return customerName;
	}
	public void setCustomeName(String customeName) {
		this.customerName = customeName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	

}
