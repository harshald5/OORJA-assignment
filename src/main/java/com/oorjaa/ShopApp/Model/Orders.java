package com.oorjaa.ShopApp.Model;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Orders {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int orderId;
	@ManyToOne
	@JoinColumn(name = "cid")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "pid")
	private Products product;
	private double value; // Final value of product with offer or without offer
	
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}



}
