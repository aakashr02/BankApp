package com.example.demo.models;

public class Login {

	private int CustomerID;
	private String password;
	public Login(int customerID, String password) {
		super();
		CustomerID = customerID;
		this.password = password;
	}
	public Login() {
		super();
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
