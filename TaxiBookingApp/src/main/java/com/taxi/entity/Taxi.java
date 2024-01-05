package com.taxi.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Taxi")
public class Taxi {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taxiNo;
	private String checkList;
	private long totalEarnings;
	private String taxiLoc;
	private int DropTime;

	public int getTaxiNo() {
		return taxiNo;
	}

	public void setTaxiNo(int taxiNo) {
		this.taxiNo = taxiNo;
	}

	public String getCheckList() {
		return checkList;
	}

	public void setCheckList(String checkList) {
		this.checkList = checkList;
	}

	public long getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(long totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public String getTaxiLoc() {
		return taxiLoc;
	}

	public void setTaxiLoc(String taxiLoc) {
		this.taxiLoc = taxiLoc;
	}

	public int getDropTime() {
		return DropTime;
	}

	public void setDropTime(int dropTime) {
		DropTime = dropTime;
	}

	

	public Taxi(int taxiNo, String checkList, long totalEarnings, String taxiLoc, int dropTime) {
		super();
		this.taxiNo = taxiNo;
		this.checkList = checkList;
		this.totalEarnings = totalEarnings;
		this.taxiLoc = taxiLoc;
		this.DropTime = dropTime;
	}

	public Taxi() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Taxi [taxiNo=" + taxiNo + ", checkList=" + checkList + ", totalEarnings=" + totalEarnings + ", taxiLoc="
				+ taxiLoc + ", DropTime=" + DropTime + "]";
	}

}
