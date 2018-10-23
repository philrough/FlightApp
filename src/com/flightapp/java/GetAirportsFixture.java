package com.flightapp.java;

import static java.util.Arrays.asList;
import java.util.ArrayList;
import java.util.List;

public class GetAirportsFixture {

	public void table(List<List<String>> table) {
	}	// Method needed to support query fixture
	 
	  
	public List<List<List<Object>>> query() {
			ArrayList airports = FlightSearch.getAirportsFromDataStore();
			
		return
			asList( // table level
				asList( // row level
					asList("airports", airports.get(0))
				),
				asList(
					asList("airports", airports.get(1))
				),
				asList( // row level
					asList("airports", airports.get(2))
				),
				asList( // row level
					asList("airports", airports.get(3))
				)
			);
				
	}

}
	
