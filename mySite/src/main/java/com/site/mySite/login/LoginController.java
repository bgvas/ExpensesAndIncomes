package com.site.mySite.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	@Autowired
	LoginService login = new LoginService();
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getValue(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginMsg(@RequestParam String user, String pass, String er, ModelMap model) {
		
		if(login.checkUser(user, pass)) {
			model.put("user", "Correct");
			return "mainMenu";
		}
		else {
			model.put("er", "Rong username or password!!!");
			return "login";
		}
	
	}
	
	@RequestMapping("/mainMenu")
	public String mainMenu() {
		return "mainMenu";
	}
	
}
