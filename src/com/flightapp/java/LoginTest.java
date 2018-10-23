package com.flightapp.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

public class LoginTest {
	
	// Tests to verify UI Methods
	@Test
	public void LoginSuccessWhenCorrectCredentialsEntered() {
		String uName = "Admin";
		char[] pWord = {'A', 'd', 'm', 'i', 'n'};
		assertEquals("", Login.CheckUserCredentialsFromDataStore(uName, pWord));
	}
	
	@Test
	public void LoginFailureWhenIncorrectCredentialsEntered() {
		String uName = "Test";
		char[] pWord = {'T', 'e', 's', 't'};
		assertEquals("User Credentiels are incorrect.", Login.CheckUserCredentialsFromDataStore(uName, pWord));
	}
	
	@Test
	public void LoginFailureWhenNoCredentialsEntered() {
		String uName = "";
		char[] pWord = {};
		assertEquals("Please Enter User Credentials.", Login.CheckUserCredentialsFromDataStore(uName, pWord));
	}

	@Test
	public void CancelButtonDisposesJFrame() {

		LoginUI loginUI = new LoginUI();
		loginUI.cancel.doClick();
	}

	@Test
	public void ApplyWithUserCredentialsReturnsNull() {

		LoginUI loginUI = new LoginUI();
		loginUI.user.setText("Admin");
		loginUI.pword.setText("Admin");
		loginUI.apply.doClick();
		assertEquals("",loginUI.errMsg.getText());
	}
	
	@Test
	public void ApplyWhenNoUserCredentialsReturnsErrorMessage() {
		LoginUI loginUI = new LoginUI();
		loginUI.user.setText("");
		loginUI.pword.setText("");
		loginUI.apply.doClick();
		assertNotNull(loginUI.errMsg.getText());
	}
}
