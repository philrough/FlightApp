package com.flightapp.java;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {

	Login server = new Login(this);

	// Set up main Panel
	JFrame lp = new JFrame("Quality Tours - Flight Application");

	// Set up North panel
	JLabel north = new JLabel("Welcome to Qualty Tours ...", JLabel.CENTER);

	// Set up West panel
	JPanel west = new JPanel();

	// Set up Centre panel
	JLabel center = new JLabel();
	JLabel userLabel = new JLabel("User Name:", JLabel.CENTER);
	JLabel pwordLabel = new JLabel(" Password: ", JLabel.CENTER);
	JTextField user = new JTextField(10);
	JPasswordField pword = new JPasswordField(10);
	JLabel errMsg = new JLabel();

	// Set up East panel
	// JLabel east = new JLabel("East", JLabel.CENTER);
	JPanel east = new JPanel();

	// Set up South panel
	JPanel south = new JPanel(new FlowLayout());
	JButton apply = new JButton("Apply");
	JButton cancel = new JButton("Cancel");

	public LoginUI() {
		// Login panel
		lp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = lp.getContentPane();
		pane.setLayout(new BorderLayout());

		// North Panel
		north.setFont(new Font("Courier", Font.BOLD, 20));
		north.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		pane.add(north, BorderLayout.NORTH);

		// North Panel
		west.setFont(new Font("Courier", Font.BOLD, 6));
		west.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		west.setPreferredSize(new Dimension(100, 200));
		pane.add(west, BorderLayout.WEST);

		// Centre Panel
		center.setFont(new Font("Courier", Font.BOLD, 20));
		center.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		SpringLayout layout = new SpringLayout();
		center.setLayout(layout);
		center.add(userLabel);
		center.add(user);
		center.add(pwordLabel);
		center.add(pword);
		center.add(errMsg);

		// Put constraint on components
		layout.putConstraint(SpringLayout.WEST, userLabel, 15, SpringLayout.WEST, center);
		layout.putConstraint(SpringLayout.NORTH, userLabel, 10, SpringLayout.NORTH, center);
		layout.putConstraint(SpringLayout.WEST, user, 15, SpringLayout.EAST, userLabel);
		layout.putConstraint(SpringLayout.NORTH, user, 10, SpringLayout.NORTH, center);

		layout.putConstraint(SpringLayout.WEST, pwordLabel, 15, SpringLayout.WEST, center);
		layout.putConstraint(SpringLayout.NORTH, pwordLabel, 30, SpringLayout.NORTH, userLabel);
		layout.putConstraint(SpringLayout.WEST, pword, 15, SpringLayout.EAST, pwordLabel);
		layout.putConstraint(SpringLayout.NORTH, pword, 30, SpringLayout.NORTH, user);

		layout.putConstraint(SpringLayout.WEST, errMsg, 15, SpringLayout.WEST, center);
		layout.putConstraint(SpringLayout.NORTH, errMsg, 30, SpringLayout.NORTH, pwordLabel);

		east.setPreferredSize(new Dimension(350, 200));
		pane.add(center, BorderLayout.CENTER);

		// East Panel
		east.setFont(new Font("Courier", Font.BOLD, 36));
		east.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		east.setPreferredSize(new Dimension(100, 190));
		pane.add(east, BorderLayout.EAST);

		// South Panel
		south.setFont(new Font("Courier", Font.BOLD, 36));
		south.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		south.add(apply);
		south.add(cancel);
		pane.add(south, BorderLayout.SOUTH);

		apply.addActionListener(server);
		cancel.addActionListener(server);

		lp.setSize(450, 200);
		lp.setVisible(true);
		lp.setResizable(false);
	}
	
	public static void main(String[] args) {
		new LoginUI();

	}
}