package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
	
	@Id
	private int customerID;
	private int phone;
	private String password;
	private int accountNo;
	private String IFSC;
	private String type;
	private int balance;
	
	
	public Account() {
		super();
	}
	public Account(int customerID, int phone, String password, int accountNo, String iFSC, String type, int balance) {
		super();
		this.customerID = customerID;
		this.phone = phone;
		this.password = password;
		this.accountNo = accountNo;
		IFSC = iFSC;
		this.type = type;
		this.balance = balance;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBalance() {
		return balance;
	}
	public void setMobile(int balance) {
		this.balance = balance;
	}
		
	
}
