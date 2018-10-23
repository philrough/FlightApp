package com.flightapp.java;

import java.io.IOException;
import java.util.ArrayList;

public class GetFlightDetailsFixture {
	String departure = "";
	String arrival = "";
	String tktclass = "";
	String tickets = "";
	String airline = "";
	String airfare = "";
	
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	
	public String tktclass() {
		return tktclass;
	}
	
	public String airline() {
		return  airline;
	}

	public String airfare() {
		return  airfare;
	}
	
	public void execute() throws IOException {
		ArrayList flightDetails = FlightSearch.getFlightDetailsFromDataStore(departure, arrival);
		if (flightDetails.size() > 0)	{
			tktclass = (String) flightDetails.get(0);
			airline = (String) flightDetails.get(1);
			airfare = (String) flightDetails.get(2);
		}
	}
}