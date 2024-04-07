package com.example.ticketbookingapp.model;

public class Passenger {
	
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String from;
	private String to;
	private int paidAmount;
	private String sectionPreference;
	private int seatNumber;
	private String allotedSection;
	private int userId;
	
	public Passenger(String firstName, String lastName, String emailAddress, String from, String to, int paidAmount, String sectionPreference) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.from = from;
		this.to = to;
		this.paidAmount = paidAmount;
		this.sectionPreference = sectionPreference;
		this.allotedSection="";
		this.seatNumber = -1;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	

	public String getSectionPreference() {
		return sectionPreference;
	}

	public void setSectionPreference(String sectionPreference) {
		this.sectionPreference = sectionPreference;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAllotedSection() {
		return allotedSection;
	}

	public void setAllotedSection(String allotedSection) {
		this.allotedSection = allotedSection;
	}

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", from=" + from + ", to=" + to + ", paidAmount=" + paidAmount + ", seatNumber=" + seatNumber
				+ ", allotedSection=" + allotedSection + ", userId=" + userId + "]";
	}
	
	
	
	
	

}
