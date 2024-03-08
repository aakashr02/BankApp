package com.example.demo.models;

public class Login {

	private int customerID;
	private String password;
	public Login(int customerID, String password) {
		super();
		this.customerID = customerID;
		this.password = password;
	}
	public Login() {
		super();
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
