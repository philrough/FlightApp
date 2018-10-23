package com.flightapp.java;

public class CheckUserCredentialsFixture {
	String username;
	String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String errorMessage() {
		return Login.CheckUserCredentialsFromDataStore(username, password.toCharArray());
	}
	
}
