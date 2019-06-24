package com.site.mySite.incomes;

import java.time.LocalDate;

import com.site.mySite.transactions.Transactions;

public class Incomes implements Transactions {
	
	private String description;
	private double amount;
	private LocalDate date;
	private String type;

	
	public Incomes() {
		this.description = null;
		this.amount = 0;
		this.type = null;
		this.date = null;
	}
	
	public Incomes(String description, String type, double amount) {
		this.description = description;
		this.type = type;
		this.amount = amount;
		this.date = LocalDate.now();
	}
	
	@Override
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String getType() {
		return this.type;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public void setDateOfTransaction(LocalDate date) {
		this.date = date;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public double getAmount() {
		return this.amount;
	}

	@Override
	public LocalDate getDate() {
		return date;
	}

}
