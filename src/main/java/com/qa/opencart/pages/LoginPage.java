package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	//1.String Locators
	private String emailID="//input[@id='input-email']";
	private String password = "//input[@id='input-password']";
	private String loginBtn = "//input[@value='Login']";
	private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";
	
	//2. page Constructor:
	public LoginPage(Page page) {
		this.page= page;	}
	
	//3. page actions/methods
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public boolean isForgotPwdLinkExists() {
	 return	page.isVisible(forgotPwdLink);
	} 
	
	public boolean doLogin(String appUsername, String appPassword) {
		System.out.println("App creds: " +appUsername);
		page.fill(emailID, appUsername);
		page.fill(password, appPassword);
		page.click(loginBtn);	
		if(page.isVisible(logoutLink)) {
			System.out.println("user is logged in successfully...");
			return true;
		}return false;
	}
}
