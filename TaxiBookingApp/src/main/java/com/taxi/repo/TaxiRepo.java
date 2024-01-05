package com.taxi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taxi.entity.Taxi;

public interface TaxiRepo extends JpaRepository<Taxi, Integer> {

	@Query(value="select * from Taxi ORDER BY totalEarnings",nativeQuery=true)
	boolean findByTaxiLoc(char pickupPoint);

	@Query(value="select * from Taxi where taxiLoc=?",nativeQuery=true)
	List<Taxi> findbyLeastEarnings();
}
