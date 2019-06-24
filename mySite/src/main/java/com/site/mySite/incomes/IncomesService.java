package com.site.mySite.incomes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class IncomesService {
	
	private List<Incomes> incomesList = new ArrayList<>();
	
	public void addNewIncome(Incomes income) {
		incomesList.add(income);
	}
	
	public List<Incomes> incomesList(){
		return incomesList;
	}
	
	public double getIncomesTotalAmount() {
		double incomesTotalAmount = 0;
		for(Incomes income:incomesList) {
			incomesTotalAmount += income.getAmount();
		}
		return incomesTotalAmount;
	}
	
	public List<Incomes> getIncomesListOfSpecificMonth(String month) {
		List<Incomes> incomesListOfSpecificMonth = new ArrayList<>();
		for(Incomes income:incomesList) {
			if(income.getDate().getMonth().toString().equals(month)) {
				incomesListOfSpecificMonth.add(income);
			}
		}
		return incomesListOfSpecificMonth;
	}
	
	public double getIncomesTotalAmountOfSpecificMonth(String month) {
		double incomesTotalAmountForSpecificMonth = 0;
		for(Incomes income:incomesList) {
			if(income.getDate().getMonth().toString().equals(month)){
				incomesTotalAmountForSpecificMonth += income.getAmount();
			}
		}
		return incomesTotalAmountForSpecificMonth;
	}
	

}
