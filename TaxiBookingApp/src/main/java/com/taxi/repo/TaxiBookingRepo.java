package com.taxi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxi.entity.TaxiBooking;

public interface TaxiBookingRepo extends JpaRepository<TaxiBooking, Integer> {

}
