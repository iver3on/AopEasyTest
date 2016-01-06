package com.test.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmartBoss {

	private CtripBookingService bookingService;

	public CtripBookingService getBookingService() {
		return bookingService;
	}

	public void setBookingService(CtripBookingService bookingService) {
		this.bookingService = bookingService;
	}

	public void goSomewhere() {
		bookingService.bookFlight();
	}
}