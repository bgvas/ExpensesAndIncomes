package com.site.mySite.login;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	private LoginElements loginElements = new LoginElements();
	
	public LoginService() {
	
	}

	public boolean checkUser(String userName, String passWord) {
		if(loginElements.GetEncrypted(userName).toString().equals(loginElements.getUserName()) && 
				loginElements.GetEncrypted(passWord).toString().equals(loginElements.getPassWord())){
			
			return true;
		}
		else {	return false;}
	}
	

}
