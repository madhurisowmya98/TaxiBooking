package com.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taxi.entity.Taxi;
import com.taxi.entity.TaxiBooking;
import com.taxi.service.TaxiService;

@RestController
public class TaxiController {
	@Autowired
	TaxiService taxiservice;

	@PostMapping("/createTaxi")
	public Taxi createTaxis(@RequestBody int details) {
		System.out.println("-----------------entered controller------------------");
		Taxi bookedDetails = taxiservice.createTaxis(details);
		System.out.println(bookedDetails);
		return bookedDetails; 
	}
	
	@PostMapping("/bookTaxi")
	public Taxi booktaxi(@RequestBody TaxiBooking details) {
		System.out.println("-----------------entered controller------------------");
		Taxi bookedDetails = taxiservice.booktaxi(details);
		System.out.println(bookedDetails);
		return bookedDetails; 
	}
	
	@GetMapping("/getAllTaxis")
	public List<Taxi> getAllTaxis() {
		System.out.println("================ getting All Taxis ========");
		List<Taxi> allTaxiDetails = taxiservice.getAllTaxis();
		System.out.println(allTaxiDetails);
		return allTaxiDetails;
		
	}
}
