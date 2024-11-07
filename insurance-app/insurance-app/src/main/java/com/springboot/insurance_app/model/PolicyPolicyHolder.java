package com.springboot.insurance_app.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "policy_policyholder")
public class PolicyPolicyHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Policy policy;
	
	@ManyToOne
	private PolicyHolder policyHolder;
	
	private LocalDate dateOfPurchase;
	
	private LocalDate dateOfRenewal;
	
	private double premium;
	
	public int getId() {
		return id;
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public LocalDate getDateOfRenewal() {
		return dateOfRenewal;
	}

	public void setDateOfRenewal(LocalDate dateOfRenewal) {
		this.dateOfRenewal = dateOfRenewal;
	}

	public void setPolicyHolder(PolicyHolder policyHolder2) {
		// TODO Auto-generated method stub
		
	}

	public void setPolicy(Policy policy2) {
		// TODO Auto-generated method stub
		
	}

	public void setActive(boolean status) {
		// TODO Auto-generated method stub
		
	}
	
}
