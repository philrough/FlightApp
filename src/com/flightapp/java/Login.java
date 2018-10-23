package com.flightapp.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login implements ActionListener{
	
	LoginUI gui;
	
	public Login (LoginUI in) {
		gui = in;
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("Apply"))
			startAccept();
		if (command.equals("Cancel"))
			startCancel();
	}
	
	public void startAccept() {
		String errTxt = (String) CheckUserCredentialsFromDataStore(gui.user.getText(), gui.pword.getPassword());
		if (errTxt.length() == 0) {
			gui.lp.setVisible(false);
			gui.lp.dispose();
			new FlightSearchUI();
		} else 
			gui.errMsg.setText(errTxt);
	}

	public void startCancel() {
		gui.lp.setVisible(false);
		gui.lp.dispose();
	}
	
	public static String CheckUserCredentialsFromDataStore(String uName, char[] pWord) {
		if (uName.length() == 0) 
			return ("Please Enter User Credentials.");
		if (ReadDataFromDataStore.CheckUserCredentials(uName, pWord))
			return "";
		else
			return("User Credentiels are incorrect.");
	}
	
}