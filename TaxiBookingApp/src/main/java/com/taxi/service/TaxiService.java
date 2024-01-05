package com.taxi.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxi.entity.Taxi;
import com.taxi.entity.TaxiBooking;
import com.taxi.repo.TaxiBookingRepo;
import com.taxi.repo.TaxiRepo;

@Service
public class TaxiService {

	@Autowired
	TaxiRepo taxiRepo;
	private List<Taxi> taxis;
	int numberOfTaxis = 4;

	@Autowired
	TaxiBookingRepo taxiBookingRepo;

	@SuppressWarnings("unlikely-arg-type")
	public Taxi booktaxi(TaxiBooking details) {
		System.out.println(">>>>>>>>>>>  entered service  >>>>>>>>>>>>>>>>>");
		int pt = details.getPickupTime();
		int pp = details.getPickupPoint();
		int dp = details.getDroppingPoint();

		int distance = (dp >= pp) ? (dp - pp) : (pp - dp);
		int distance1 = distance * 15 - 5;
		long cost = 100 + distance1 * 10;
		int dt = pt + distance;

		details.setDropTime(dt);
		details.setAmount(cost);

		Taxi taxidetails = new Taxi();
		System.out.println("created Taxi Object");
		// finding taxis in Taxi
		List<Taxi> td = taxiRepo.findbyLeastEarnings();
		System.out.println("=================  find All from DB  ============");
		if (td == null || td.isEmpty()) {
			System.out.println("=====================  Taxi Entity is empty  ==================");
			// create new taxis if there are no taxis
//			taxis = new ArrayList<>();
//			for (int i = 1; i <= numberOfTaxis; i++) {
//				Taxi newTaxi = new Taxi(i, "FREE", 0, "A", 0);
////				newTaxi.setTaxiNo(i);
////				newTaxi.setCheckList("FREE");
////				newTaxi.setTotalEarnings(0);
//				taxis.add(newTaxi);
//			}
//			System.out.println("===========  About to save  =========");
//			// Save the new taxis
//			taxiRepo.saveAll(taxis);
//			System.out.println("saved taxis");
			// Assign the first taxi to the booking
//			taxidetails = taxis.get(0); 
//			taxidetails.setCheckList("ONDUTY"); 
//			details.setTaxi(taxidetails);
		} else {

			for (Taxi taxi : td) {
				// get the free taxis of that particular location
				if (taxi.getTaxiLoc().equals(details.getPickupPoint())) {
					if (taxi.getDropTime() < details.getPickupTime()) {
						// Reset checkList to "FREE" or appropriate status
						taxidetails.setTotalEarnings(taxi.getTotalEarnings() + details.getAmount());
						taxidetails.setCheckList("ONDUTY");
						details.setTaxi(taxidetails);
						break;
					}
				}
			}

			// pp.details == dp.taxidetails

			// chek which is having less earnings
//			System.out.println("===============  getting less earning taxi  ============");
			// Get the taxi with the minimum earnings
//			taxidetails = td.stream().min(Comparator.comparingLong(Taxi::getTotalEarnings)).orElse(null);
			// if not available check the near location taxis which are free

			details.setTaxi(taxidetails);
		}

		// Update taxi earnings and save in Taxi
//		long newTotalEarnings = taxidetails.getTotalEarnings() + cost;
//		taxidetails.setTotalEarnings(newTotalEarnings);
		Taxi returnedDetails = taxiRepo.save(taxidetails);
		System.out.println("====== updated taxi total earnings =========");
		// save booking details in TaxiBooking
		TaxiBooking bookingDetails = taxiBookingRepo.save(details);
		return returnedDetails;
	}

	public List<Taxi> getAllTaxis() {
		// TODO Auto-generated method stub
		List<Taxi> returnedDetails = taxiRepo.findAll();
		return returnedDetails;
	}

	public Taxi createTaxis(int details) {
		Taxi taxidetails = new Taxi();
		// TODO Auto-generated method stub
		taxis = new ArrayList<>();
		for (int i = 1; i <= numberOfTaxis; i++) {
			Taxi newTaxi = new Taxi(i, "FREE", 0, "A", 0);
//			newTaxi.setTaxiNo(i);
//			newTaxi.setCheckList("FREE");
//			newTaxi.setTotalEarnings(0);
			taxis.add(newTaxi);
		}
		System.out.println("===========  About to save  =========");
		// Save the new taxis
		taxiRepo.saveAll(taxis);
		System.out.println("saved taxis");
		return null;

	}

}
