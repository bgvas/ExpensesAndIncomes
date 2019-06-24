package com.site.mySite.expenses;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExpensesController {
	
	private LocalDate date = LocalDate.now();
	
	@Autowired
	private ExpensesService expensesService;
	
	@RequestMapping(value = "/expenses", method = RequestMethod.GET)
	public String addNewExpense() {
		return "addNewExpense";
	}
	
	@RequestMapping(value = "/expenses", method = RequestMethod.POST)
	public String newExpense(ModelMap model, @RequestParam String description, String type, double amount){
		expensesService.addExpense(new Expenses(description, type, amount));
		model.put("description", description);
		model.put("amount", amount);
		model.put("type", type);
		model.put("date", this.date);
		return "printNewExpense";
	}
	
	@RequestMapping(value = "/allExpensesList", method = RequestMethod.GET)
	public String expensesList(ModelMap model){
		model.put("expenses", expensesService.getExpensesList());
		model.put("totalAmount", expensesService.getTotalExpensesAmount());
		return "expensesList";		
	}
	
	@RequestMapping(value = "/expensesPerMonth", method = RequestMethod.GET)
	public String setMonthForExpenses() {
		return "getMonthForExpensesList";
	}
		
	@RequestMapping(value = "/expensesPerMonth", method = RequestMethod.POST)
	public String getExpensesListOfSpecificMonth(ModelMap model, @RequestParam String month) {
		model.put("month", month);
		if(expensesService.getTotalExpensesAmountOfSpecificMonth(month) != 0) {
			model.put("expensesList", expensesService.getExpensesListOfSpecificMonth(month));
			model.put("totalAmount", expensesService.getTotalExpensesAmountOfSpecificMonth(month));
			return "expensesListOfSpecificMonth";
		}
		else {
			model.put("noExpenses", "There are no expenses for  ");
			return "expensesListOfSpecificMonth";
		}
	}
		
	
	
	
}
