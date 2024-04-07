package com.example.ticketbookingapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketbookingapp.model.Passenger;
import com.example.ticketbookingapp.service.AppService;


@RestController
@RequestMapping("/api/v1/product")
public class AppController {
	
	@Autowired
	AppService appService;
	
	@GetMapping("/HelloWorld")
	public ResponseEntity<Object> hello() {
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	}
	
	
	
	@PostMapping("/bookTicket")
	public String bookTicket(@RequestBody Passenger p) {
		
		return appService.bookTicket(p);
		
	}
	@GetMapping("/allPassenger")
	public Map<Integer, Passenger> getAllPassenger(){
		return appService.getAllPassenger();
	}
	
	@GetMapping("/getTicketByID/{id}")
	public String getTicketDetails(@PathVariable int id) {
		return appService.getPassengerByID(id);
	}
	
	@GetMapping("/getTiccketBySection/{section}")
	public List<Passenger> getTicketDetails(@PathVariable String section) {
		return appService.getPassengersBySection(section);
	}
	
	@DeleteMapping("/deleteTicket/{id}")
	public String deleteProduct(@PathVariable int id) {
		return appService.deletePassenger(id);
	}
	
	@PutMapping("/updateSeat/{id}/{seatNumber}/{section}")
	public String updateSeat(@PathVariable int id,@PathVariable int seatNumber,@PathVariable String section) {
		return appService.updateSeat(id, seatNumber, section);
	}
	

}
