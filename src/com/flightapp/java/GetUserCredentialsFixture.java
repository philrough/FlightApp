package com.flightapp.java;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class GetUserCredentialsFixture {
	String firstname = "";
	String lastname = "";
	String company = "";
	ArrayList userCredentials;
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String lastname() {
		return lastname;
	}
	
	public String company() {
		return  company;
	}
		
	public void execute() {
		ArrayList userCredentials = FlightSearch.getUserCredentialsFromDataStore(firstname);
		if (userCredentials.size() > 0)	{
			firstname = (String) userCredentials.get(0);
			lastname = (String) userCredentials.get(1);
			company = (String) userCredentials.get(2);
		}
	}
}