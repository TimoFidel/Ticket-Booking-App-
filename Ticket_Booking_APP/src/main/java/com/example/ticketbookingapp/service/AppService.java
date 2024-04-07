package com.example.ticketbookingapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.ticketbookingapp.model.Passenger;

@Service
public class AppService {
	
	public static int userId=0;
	

	List<Passenger> bookedTicketSectionA = new ArrayList<>();
	List<Passenger> bookedTicketSectionB = new ArrayList<>();
	
	List<Integer> sectionA = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	
	List<Integer> sectionB = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	
	Map<Integer, Passenger> passengers = new HashMap<>();
	
	
	public String bookTicket(Passenger p){
		
		if(p.getSectionPreference().equals("A") && sectionA.size()>0) {
			//int id=userId++;
			userId++;
			p.setUserId(userId);
			p.setAllotedSection("A");
			p.setSeatNumber(sectionA.get(0));
			sectionA.remove(0);
			passengers.put(userId, p);
			bookedTicketSectionA.add(p);
		}
		else if(p.getSectionPreference().equals("B") && sectionB.size()>0) {
			userId++;
			p.setUserId(userId);
			p.setAllotedSection("B");
			p.setSeatNumber(sectionB.get(0));
			sectionB.remove(0);
			passengers.put(userId, p);
			bookedTicketSectionB.add(p);
		}
		else if(sectionA.size()>0) {
			userId++;
			p.setUserId(userId);
			p.setAllotedSection("A");
			p.setSeatNumber(sectionA.get(0));
			sectionA.remove(0);
			passengers.put(userId, p);
			bookedTicketSectionA.add(p);
		}
		else if(sectionB.size()>0) {
			userId++;
			p.setUserId(userId);
			p.setAllotedSection("B");
			p.setSeatNumber(sectionB.get(0));
			sectionB.remove(0);
			passengers.put(userId, p);
			bookedTicketSectionB.add(p);
		}
		else {
			return "No Seats Available";
		}
		
		return p.toString();
	}


	public String getPassengerByID(int Id) {
		if(passengers.containsKey(Id)) {
			return passengers.get(Id).toString();
		}
		else {
			return "Given ID is not available";
		}
	}
	public Map<Integer, Passenger> getAllPassenger() {
		// TODO Auto-generated method stub
		return passengers;
	}
	
	public List<Passenger> getPassengersBySection(String section){
		if(section.equals("A")) {
			return bookedTicketSectionA;
		}
		else {
			return bookedTicketSectionB;
		}
	}
	
	public String deletePassenger(int id) {
		
		
		if(passengers.containsKey(id)) {
			Passenger p = passengers.get(id);
			passengers.remove(id);
			
			if(p.getAllotedSection().equals("A")) {
				bookedTicketSectionA.remove(p);
				sectionA.add(p.getSeatNumber());
			}
			else {
				bookedTicketSectionB.remove(p);
				sectionB.add(p.getSeatNumber());
			}
			return "Ticket Cancelled Successfully";
		}
		
		return "Given ID is not available";
	}
	
	public String updateSeat(int id, int seatNumber, String section) {
		if(section.equals("A") && sectionA.contains(seatNumber)) {
			if(passengers.containsKey(id)) {
				Passenger p = passengers.get(id);
				int prevSeatNumber = p.getSeatNumber();
				p.setSeatNumber(seatNumber);
				p.setAllotedSection(section);
				sectionA.remove(seatNumber);
				sectionA.add(prevSeatNumber);
				return p.toString();
				
			}
			else {
				return "Given ID is not available";
			}
		}
		else if(section.equals("B") && sectionA.contains(seatNumber)) {
			if(passengers.containsKey(id)) {
				Passenger p = passengers.get(id);
				int prevSeatNumber = p.getSeatNumber();
				p.setSeatNumber(seatNumber);
				p.setAllotedSection(section);
				sectionB.remove(seatNumber);
				sectionB.add(prevSeatNumber);
				return p.toString();
				
			}
			else {
				return "Given ID is not available";
			}
		}
		else {
			return "Requested Seat is not available";
		}
		
		
	}

}
