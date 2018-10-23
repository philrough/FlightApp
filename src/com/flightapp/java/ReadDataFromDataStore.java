package com.flightapp.java;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadDataFromDataStore {
	
	public static Boolean CheckUserCredentials(String uName, char[] pWord) {
		boolean validUser = false;
	
	 try {
         File file = new File("DataStore.xml");
         DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
          
         DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
         Document document = documentBuilder.parse(file);
          
         document.getDocumentElement().normalize();
          
         NodeList nodeList = document.getElementsByTagName("employee");
          
         for (int index = 0; index < nodeList.getLength(); index++) {
             Node node = nodeList.item(index);

             if (node.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) node;
                 String dataStoreUserName = eElement.getElementsByTagName("firstname").item(0).getTextContent();
                 if (dataStoreUserName.equals(uName))
                	 	validUser = true;
             }
         }
     } catch (Exception e) {
         System.err.println(e.getMessage());
         e.printStackTrace();
     }
	
	return validUser;
	}
	
	public static ArrayList<String> GetUserCredentials(String uName) {
		ArrayList<String> userCredentials = new ArrayList<String>();
	
	 try {
         File file = new File("DataStore.xml");
         DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
          
         DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
         Document document = documentBuilder.parse(file);
          
         document.getDocumentElement().normalize();
          
         NodeList nodeList = document.getElementsByTagName("employee");
          
         for (int index = 0; index < nodeList.getLength(); index++) {
             Node node = nodeList.item(index);

             if (node.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) node;
                 String dataStoreUserName = eElement.getElementsByTagName("firstname").item(0).getTextContent();
                 if (dataStoreUserName.equals(uName)) {
                	 userCredentials.add(eElement.getElementsByTagName("firstname").item(0).getTextContent());
                	 userCredentials.add(eElement.getElementsByTagName("lastname").item(0).getTextContent());
                	 userCredentials.add(eElement.getElementsByTagName("designation").item(0).getTextContent());
                	 break;
                 }
             }
         }
     } catch (Exception e) {
         System.err.println(e.getMessage());
         e.printStackTrace();
     }
	
	
	return userCredentials;
	}


	public static ArrayList<String> getAirports() {
		ArrayList<String> dataStoreAirports = new ArrayList<String>();

		try {
			File file = new File("DataStore.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
      
			document.getDocumentElement().normalize();
      
			NodeList nodeList = document.getElementsByTagName("airports");
      
			for (int index = 0; index < nodeList.getLength(); index++) {
				Node node = nodeList.item(index);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					dataStoreAirports.add(eElement.getElementsByTagName("airport").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			}


		return dataStoreAirports;
	}

	public static ArrayList<String> GetFlightDetails(String departure, String arrival) {
		ArrayList<String> dataStoreFlights = new ArrayList<String>();

		try {
			File file = new File("DataStore.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
      
			document.getDocumentElement().normalize();
      
			NodeList nodeList = document.getElementsByTagName("prices");
      
			for (int index = 0; index < nodeList.getLength(); index++) {
				Node node = nodeList.item(index);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					String airway = eElement.getElementsByTagName("airway").item(0).getTextContent();
					if (airway.equals(departure + "-" + arrival)) {
						dataStoreFlights.add(eElement.getElementsByTagName("airclass").item(0).getTextContent());
						dataStoreFlights.add(eElement.getElementsByTagName("airline").item(0).getTextContent());
						dataStoreFlights.add(eElement.getElementsByTagName("airfare").item(0).getTextContent());
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			}


		return dataStoreFlights;
	}
}