package com.oorjaa.ShopApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AvailedOffer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int availId;
	private String offeridcid;
	private int cid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public int getAvailId() {
		return availId;
	}
	public void setAvailId(int availId) {
		this.availId = availId;
	}
	public String getOfferidcid() {
		return offeridcid;
	}
	public void setOfferidcid(String offeridcid) {
		this.offeridcid = offeridcid;
	}

}
