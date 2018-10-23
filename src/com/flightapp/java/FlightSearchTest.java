package com.flightapp.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class FlightSearchTest {
	


	@Test
	public void AllAirportsReturnedFromFlightServer() {
		ArrayList airports = FlightSearch.getAirportsFromDataStore();
		assertEquals(4, airports.size());
		assertEquals("London Gatwick", airports.get(0));
		assertEquals("London Heathrow", airports.get(1));
		assertEquals("Paris CDG", airports.get(2));
		assertEquals("Paris Orly", airports.get(3));

	}
	
	@Test
	public void GetUserCredentialsFromFlightServer() {
		ArrayList userCredentials = FlightSearch.getUserCredentialsFromDataStore("Abe");
		assertEquals(3, userCredentials.size());
		assertEquals("Abe", userCredentials.get(0));
		assertEquals("Lincoln", userCredentials.get(1));
		assertEquals("Top Hat Adventures", userCredentials.get(2));
	}

	@Test
	public void GetFlightDetailsFromDataStore() {
		ArrayList flightDetails = FlightSearch.getFlightDetailsFromDataStore("LGW", "CDG");
		assertEquals("Coach", flightDetails.get(0));
		assertNotNull(flightDetails.get(1));
	}
	
	@Test
	public void CheckAirportCode() {
		ArrayList flightDetails = FlightSearch.getFlightDetailsFromDataStore("London Gatwick", "Paris CDG");
		assertEquals("LGW", FlightSearch.getAirportCode("London Gatwick"));
	}

	@Test
	public void SearchWithCredentialsUpdatesTable() {

		FlightSearchUI flightUI = new FlightSearchUI();
		flightUI.airportDep.setSelectedItem("London Gatwick");
		flightUI.airportArr.setSelectedItem("Paris CDG");
		flightUI.search.doClick();
		assertEquals("LGW", flightUI.flightTable.getValueAt(0, 0));
	}
	
}