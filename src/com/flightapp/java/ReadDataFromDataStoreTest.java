package com.flightapp.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class ReadDataFromDataStoreTest {

	@Test
	public void CheckUserCredentialsWithValidReturnsTrue() {
		String uName = "Admin";
		char[] pWord = {'A', 'd', 'm', 'i', 'n'};
		assertEquals(true, ReadDataFromDataStore.CheckUserCredentials(uName, pWord));
	}
	
	@Test
	public void CheckUserCredentialsWithInvalidReturnsFalse() {
		String uName = "DoesNotExist";
		char[] pWord = {'D', 'U', 'M', 'M', 'Y'};
		assertEquals(false, ReadDataFromDataStore.CheckUserCredentials(uName, pWord));
	}
	
	@Test
	public void AllAirportsFromDataStoreReturnsSuccess() {
		ArrayList airports = ReadDataFromDataStore.getAirports();
		assertEquals(4, airports.size());
		assertEquals("London Gatwick", airports.get(0));
		assertEquals("London Heathrow", airports.get(1));
		assertEquals("Paris CDG", airports.get(2));
		assertEquals("Paris Orly", airports.get(3));
	}
	
	@Test
	public void GetUserCredentialsFromDataStoreReturnsSuccess() {
		ArrayList userCredentials = ReadDataFromDataStore.GetUserCredentials("Abe");
		assertEquals(3, userCredentials.size());
		assertEquals("Abe", userCredentials.get(0));
		assertEquals("Lincoln", userCredentials.get(1));
		assertEquals("Top Hat Adventures", userCredentials.get(2));
	}
	

	
	@Test
	public void GetUserCredentialsReturnedFromDataStoreReturnsNoData() {
		ArrayList userCredentials = ReadDataFromDataStore.GetUserCredentials("");
		assertEquals(0, userCredentials.size());
	}
	
	@Test
	public void GetFlightDetailsFromDataStoreReturnsSuccess() {
		ArrayList flightDetails = ReadDataFromDataStore.GetFlightDetails("LGW", "CDG");
		assertEquals("Coach", flightDetails.get(0));
		assertEquals("BAA", flightDetails.get(1));
		assertEquals("123", flightDetails.get(2));
	}
	
	@Rule
	  public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void GetFlightDetailsFromDataStoreThrowsException() {
		ArrayList flightDetails = ReadDataFromDataStore.GetFlightDetails("LGW", "");
		exception.expect(IndexOutOfBoundsException.class);
	}
	
}
