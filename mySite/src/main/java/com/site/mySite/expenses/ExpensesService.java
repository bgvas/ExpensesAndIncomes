package com.site.mySite.expenses;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ExpensesService {
	
	
	private List<Expenses> expensesList = new ArrayList<>();

	public List<Expenses> getExpensesList(){
		return expensesList;
	}
	
	public void addExpense(Expenses expense) {
		expensesList.add(expense);
	}
	
	public double getTotalExpensesAmount() {
		double expensesTotalAmount = 0;
		for(Expenses expense:expensesList) {
			expensesTotalAmount += expense.getAmount();
		}
		return expensesTotalAmount;
	}
	
	public List<Expenses> getExpensesListOfSpecificMonth(String month) {
		List<Expenses> expensesListOfSpecificMonth = new ArrayList<>();
		for(Expenses expense:getExpensesList()) {
			if(expense.getDate().getMonth().toString().equals(month)) {
				expensesListOfSpecificMonth.add(expense);
			}
		} 
		return expensesListOfSpecificMonth;
	}
	
	public double getTotalExpensesAmountOfSpecificMonth(String month) {
		double totalExpensesAmountOfSpecificMonth = 0;
		for(Expenses expense:getExpensesList()) {
			if(expense.getDate().getMonth().toString().equals(month)) {
				totalExpensesAmountOfSpecificMonth += expense.getAmount();
			}
		}
		return totalExpensesAmountOfSpecificMonth;
	}
	
	

}
