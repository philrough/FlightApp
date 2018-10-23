package com.flightapp.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.TableModel;

public class FlightSearch implements ItemListener, ActionListener {
	
	
	FlightSearchUI gui;
	
	public FlightSearch (FlightSearchUI in) {
		gui = in;
        
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("Search"))
				startSearch();
		if (command.equals("Reset"))
			startReset();
		
	}

	public void itemStateChanged(ItemEvent event) {
		Object source = event.getItemSelectable();
		if (source == gui.classFirst)
				gui.classFirst.setSelected(false);
		
	}

	private void startSearch()  {
		updateFlightTable();
	}

	private void startReset() {
		// TODO	
	}
	
	public static ArrayList<String> getAirportsFromDataStore() {
		return ReadDataFromDataStore.getAirports();
	}
	
	public static ArrayList<String> getUserCredentialsFromDataStore(String uName) {
		return ReadDataFromDataStore.GetUserCredentials(uName);
	}

	public static ArrayList getFlightDetailsFromDataStore(String departure, String arrival) {
		return ReadDataFromDataStore.GetFlightDetails(departure, arrival);
	}
	
	private void updateFlightTable() {
		final String airportDepCode = getAirportCode((String) gui.airportDep.getSelectedItem());
		final String airportArrCode = getAirportCode((String) gui.airportArr.getSelectedItem());
		ArrayList flightDetails = FlightSearch.getFlightDetailsFromDataStore(airportDepCode, airportArrCode);
		
		if (!flightDetails.isEmpty()) {
			
		
			int totalCost = Integer.parseInt(gui.numPassengers.getText()) * Integer.parseInt((String) flightDetails.get(2));
		
			gui.flightTable.setValueAt(airportDepCode, 0, 0);
			gui.flightTable.setValueAt(airportArrCode, 0, 1);
			gui.flightTable.setValueAt(flightDetails.get(0), 0, 2);
			gui.flightTable.setValueAt(gui.numPassengers.getText(), 0, 3);
			gui.flightTable.setValueAt(flightDetails.get(1), 0, 4);
			gui.flightTable.setValueAt(flightDetails.get(2) + "(" + totalCost + ")", 0, 5);
		}
	}

	public static String getAirportCode(String airport) {
		String airportCode = "Unknown";
		switch (airport) {
			case ("London Gatwick"): {
				airportCode = "LGW";
				break;
			}
			case ("London Heathrow"): {
				airportCode = "LHR";
				break;
			}
			case ("Paris CDG"): {
				airportCode = "CDG";
				break;
			}
			case ("Paris Orly"): {
				airportCode =  "ORY";
				break;
			}
		}
		return airportCode;
	}
	
}