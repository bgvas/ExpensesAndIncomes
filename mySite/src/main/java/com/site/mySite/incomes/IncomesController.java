package com.site.mySite.incomes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IncomesController {
	
	private LocalDate date = LocalDate.now();
	
	@Autowired
	private IncomesService incomesService;
	
	@RequestMapping(value = "/newIncome", method = RequestMethod.GET)
	public String addNewIncome() {
		return "addNewIncome";
	}
	
	@RequestMapping(value = "/newIncome", method = RequestMethod.POST)
	public String saveNewIncome(ModelMap model, @RequestParam String description, String type, double amount) {
		incomesService.addNewIncome(new Incomes(description, type, amount));
		model.put("description", description);
		model.put("type", type);
		model.put("amount", amount);
		model.put("date", date);
		return "printNewIncome";
	}
	
	@RequestMapping(value = "/incomesList", method = RequestMethod.GET)
	public String getIncomesList(ModelMap model) {
		model.put("incomes", incomesService.incomesList());
		model.put("totalAmount", incomesService.getIncomesTotalAmount());
		return "incomesList";
	}
	
	@RequestMapping(value = "/incomesPerMonth", method = RequestMethod.GET)
	public String getMonthForIncomesList() {
		return "getMonthForIncomes";
	}
	
	@RequestMapping(value = "/incomesPerMonth", method = RequestMethod.POST)
	public String getIncomesListForSpecificMonth(ModelMap model, @RequestParam String month) {
		model.put("month", month);
		model.put("incomesList", incomesService.getIncomesListOfSpecificMonth(month));
		model.put("totalAmount", incomesService.getIncomesTotalAmountOfSpecificMonth(month));
		return "incomesListOfSpecificMonth";
	}
	
	

}
