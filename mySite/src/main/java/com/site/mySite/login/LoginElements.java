package com.site.mySite.login;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

public class LoginElements {
	
	private String userName = null;
	private String passWord = null;
	
	public LoginElements() {
		this.passWord = "114.685112109899563392900745384395122528076171875";  //"1111"
		this.userName = "144.60660707337291341900709085166454315185546875"; // "bill"
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}
	
	public BigDecimal GetEncrypted(String element) {
		
		double encryptedToDouble = element.hashCode();
		
		encryptedToDouble = Math.cbrt(encryptedToDouble);
		
		BigDecimal encrypted = new BigDecimal(encryptedToDouble);
		
		return encrypted;
		
	}
	

}
