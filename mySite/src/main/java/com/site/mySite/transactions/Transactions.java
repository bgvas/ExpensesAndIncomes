package com.site.mySite.transactions;

import java.time.LocalDate;

public interface Transactions {
	
	
	
	public void setDescription(String description);
	public void setType(String type);
	public void setAmount(double amount);
	public void setDateOfTransaction(LocalDate date);
	
	public String getDescription();
	public String getType();
	public double getAmount();
	public LocalDate getDate();

}
