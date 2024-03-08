package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
	
	@Id
	@Column(name = "CUSTOMERID")
	private int customerID;
	@Column(name="PHONE")
	private int phone;

	@Column(name="PASSWORD")
	private String password;
	@Column(name = "ACCOUNTNO")
	private int accountNo;
	@Column(name="IFSC")
	private String IFSC;
	@Column(name="TYPE")
	private String type;
	@Column(name="BALANCE")
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
	public void setBalance(int balance) {
		this.balance = balance;
	}
		
	
}
