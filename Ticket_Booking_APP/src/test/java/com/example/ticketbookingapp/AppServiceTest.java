package com.example.ticketbookingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.ticketbookingapp.model.Passenger;
import com.example.ticketbookingapp.service.AppService;

@SpringBootTest
public class AppServiceTest {
	
	@Autowired
	private AppService appService;
	
	
	
	@Test
	  public void testBookTicket() {
		Passenger passenger = new Passenger("Timo","Fidel","apc@gmail.com","London","France",20,"A");
		//passenger.setAllotedSection("A");
		//passenger.setSeatNumber(1);
	    String result = appService.bookTicket(passenger);
	    	  
	    assertEquals("Passenger [firstName=Timo, lastName=Fidel, emailAddress=apc@gmail.com, from=London, to=France, paidAmount=20, seatNumber=2, allotedSection=A, userId=2]", result);
	  }
	
	@Test
	public void testpassengerByID() {
		int userId1 =1;
		int userId2 =2;
		Passenger mockPassenger = new Passenger("XYZ","ABC","apc@gmail.com","London","France",20,"A");
		mockPassenger.setAllotedSection("A");
		mockPassenger.setSeatNumber(1);
		
		
		
		//Mockito.when(appService.getPassengerByID(userId)).thenReturn(mockPassenger.toString());
		String addPassenger = appService.bookTicket(mockPassenger);
		String savedPassenger = appService.getPassengerByID(userId1);
		String passengerNotavailable = appService.getPassengerByID(userId2);
		
		
		assertNotNull(savedPassenger);
		assertEquals("Passenger [firstName=XYZ, lastName=ABC, emailAddress=apc@gmail.com, from=London, to=France, paidAmount=20, seatNumber=1, allotedSection=A, userId=1]",savedPassenger);
		assertEquals("Given ID is not available",passengerNotavailable);
		
	}
	
	@Test
	public void testGetAllPassenger() {
		Map<Integer, Passenger> allPassengers= appService.getAllPassenger();
		
		Passenger testPassenger1 = allPassengers.get(1);
		Passenger testPassenger2 = allPassengers.get(2);
		
		assertEquals("XYZ", testPassenger1.getFirstName());
		assertEquals("Timo", testPassenger2.getFirstName());
	}
	
	

}
