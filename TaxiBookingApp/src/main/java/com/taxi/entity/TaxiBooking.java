package com.taxi.entity;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TaxiBooking")
public class TaxiBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private char pickupPoint;
	private char droppingPoint;
	private int pickupTime;
	private int dropTime;
	private long amount;

	@ManyToOne
	@JoinColumn(name = "taxiNo")
	private Taxi taxi;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public char getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(char pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public char getDroppingPoint() {
		return droppingPoint;
	}

	public void setDroppingPoint(char droppingPoint) {
		this.droppingPoint = droppingPoint;
	}

	public int getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(int pickupTime) {
		this.pickupTime = pickupTime;
	}

	public int getDropTime() {
		return dropTime;
	}

	public void setDropTime(int dropTime) {
		this.dropTime = dropTime;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

	public TaxiBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaxiBooking(int bookingId, int customerId, char pickupPoint, char droppingPoint, int pickupTime,
			int dropTime, long amount, Taxi taxi) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.pickupPoint = pickupPoint;
		this.droppingPoint = droppingPoint;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.amount = amount;
		this.taxi = taxi;
	}

	@Override
	public String toString() {
		return "TaxiBooking [bookingId=" + bookingId + ", customerId=" + customerId + ", pickupPoint=" + pickupPoint
				+ ", droppingPoint=" + droppingPoint + ", pickupTime=" + pickupTime + ", dropTime=" + dropTime
				+ ", amount=" + amount + ", taxi=" + taxi + "]";
	}

	
}
