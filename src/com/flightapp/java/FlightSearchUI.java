package com.flightapp.java;

import static org.junit.Assert.assertEquals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class FlightSearchUI extends JFrame{
	
	FlightSearch server = new FlightSearch(this);
	
	// Set up main Panel
    JFrame mp = new JFrame("");
    
    // Set up North panel
    JPanel north = new JPanel();
    JLabel topLabel = new JLabel();
    
    // Set up West panel
    JLabel west = new JLabel(new ImageIcon("flight-Search.jpg"));

    // Set up Center panel
    JPanel center = new JPanel();
	JLabel airportDepLabel = new JLabel("Departure Airport:  ", JLabel.LEFT);
	JComboBox<String> airportDep = new JComboBox<String>();
	JLabel airportArrLabel = new JLabel("Arrival Airport:         ", JLabel.LEFT);
	JComboBox<String> airportArr = new JComboBox<String>();
	JLabel classLabel = new JLabel("Class: ", JLabel.LEFT);
	JCheckBox classFirst = new JCheckBox("First", false);
	JCheckBox classPremium = new JCheckBox("Premium", false);
	JCheckBox classCoach = new JCheckBox("Coach", false);
	JLabel numPassengersLabel = new JLabel("Number of Passengers: ", JLabel.LEFT);
	JTextField numPassengers = new JTextField("1", 5);
    
    // Set up East panel
    JPanel east = new JPanel();;
    String[] columnNames = {"Departure",
            "Arrival",
            "Class",
            "Tickets",
            "Airline",
            "Cost"};
    
    Object[][] flightData = {
    	    {"...", "...",
    	    	"...", "...", "...", "..."},
    	    {"...", "...",
        	     "...", "...", "...", "..."},
    	    {"...", "...",
        	     "...", "...", "...", "..."}
    	    };
    JTable flightTable = new JTable(flightData, columnNames);
    
    // Set up South panel
    JPanel south = new JPanel(new FlowLayout());
    JButton search = new JButton("Search");
    JButton reset = new JButton("Reset");
    
    public FlightSearchUI() {

	    mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container pane = mp.getContentPane();
	    pane.setLayout(new BorderLayout());
	    
	    // North Panel
	    north.setFont(new Font("Courier", Font.BOLD, 20));
	    north.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    ArrayList<?> userCredentials = FlightSearch.getUserCredentialsFromDataStore("Abe");
	    topLabel.setText("Welcome " + userCredentials.get(0) + " " + userCredentials.get(1) + " of " + userCredentials.get(2));
	    north.add(topLabel);
	    pane.add(north, BorderLayout.NORTH);
	    
	    // West Panel
	    west.setFont(new Font("Courier", Font.BOLD, 20));
	    west.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    west.setPreferredSize(new Dimension(100, 50));
	    pane.add(west, BorderLayout.WEST);
	    
	    // Center Panel
	    center.setFont(new Font("Courier", Font.BOLD, 20));
	    center.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		ArrayList<String> airports = FlightSearch.getAirportsFromDataStore();
		for (int i=0; i < airports.size(); i++) {
				airportDep.addItem(airports.get(i));
				airportArr.addItem(airports.get(i));
		}

		FlowLayout layout3 = new FlowLayout(FlowLayout.LEFT, 10, 10);
		center.setLayout(layout3);
		center.add(airportDepLabel);
		center.add(airportDep);
		center.add(airportArrLabel);
		center.add(airportArr);
	//	center.add(classLabel);
		center.add(classCoach);
		center.add(classPremium);
		center.add(classFirst);
		center.add(numPassengersLabel);
		center.add(numPassengers);
		center.setPreferredSize(new Dimension(250, 50));
	    pane.add(center, BorderLayout.CENTER);
	    
	    // East Panel
	    east.setFont(new Font("Courier", Font.BOLD, 20));
	    east.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    east.setLayout(new BorderLayout());
	    flightTable.setAutoResizeMode(WIDTH);
	    east.add(flightTable.getTableHeader(), BorderLayout.PAGE_START);
	    east.add(flightTable, BorderLayout.CENTER);
	    east.setPreferredSize(new Dimension(400, 50));
	    pane.add(east, BorderLayout.EAST);
	    
	    // South Panel
	    south.setFont(new Font("Courier", Font.BOLD, 20));
	    south.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	    south.add(search);
	    south.add(reset);
	    pane.add(south, BorderLayout.SOUTH);
	    
	    
	search.addActionListener(server);
	reset.addActionListener(server);
	classFirst.addItemListener(server);
	classPremium.addItemListener(server);
	classCoach.addItemListener(server);
		
	    mp.setSize(800, 300);
	    mp.setVisible(true);
	    mp.setResizable(false);
    }
    
	public static void main(String[] args) {
		new FlightSearchUI();

	}
    
}
