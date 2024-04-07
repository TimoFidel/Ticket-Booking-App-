package com.example.ticketbookingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.ticketbookingapp.controller.AppController;
import com.example.ticketbookingapp.model.Passenger;

@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest extends AbstractTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AppController()).build();
    }

	@Test
    public void testSayHelloWorld() throws Exception {
        this.mockMvc.perform(get("/api/v1/product/HelloWorld")
           .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andExpect(status().isOk());
           

    }
	
	@Test
	public void createPassenger() throws Exception {
	   String uri = "/api/v1/product/bookTicket";
	   Passenger passenger =new Passenger("Timo","Fidel","apc@gmail.com","London","France",20,"A");
	   
	   
	   String inputJson = super.mapToJson(passenger);
	   MvcResult mvcResult=this.mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals(content, "Passenger [firstName=Timo, lastName=Fidel, emailAddress=apc@gmail.com, from=London, to=France, paidAmount=20, seatNumber=2, allotedSection=A, userId=2]");
	}
	
	@Test
	public void getPassengerByID() throws Exception{
		String postUri = "/api/v1/product/bookTicket";
		Passenger passenger =new Passenger("Timo","Fidel","apc@gmail.com","London","France",20,"A");
		   
		   
		String inputJson = super.mapToJson(passenger);
	    this.mockMvc.perform(post(postUri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		   
		String uri = "/api/v1/product/getTicketByID/1";
		
		MvcResult mvcResult=this.mockMvc.perform(get(uri).accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Passenger [firstName=Timo, lastName=Fidel, emailAddress=apc@gmail.com, from=London, to=France, paidAmount=20, seatNumber=1, allotedSection=A, userId=1]");
		
		String uri2 = "/api/v1/product/getTicketByID/3";
		
		MvcResult mvcResult2=this.mockMvc.perform(get(uri2).accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andReturn();
		int status2 = mvcResult2.getResponse().getStatus();
		assertEquals(200, status2);
		String content2 = mvcResult2.getResponse().getContentAsString();
		assertEquals(content2, "Given ID is not available");
		
		
	}
	
	


}
