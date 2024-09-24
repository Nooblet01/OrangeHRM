package com.HRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HRMLoginPage {
	private WebDriver driver;

	public HRMLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(name = "username")
	WebElement usn;
	@FindBy(name = "password")
	WebElement psw;
	@FindBy(xpath = "//button[contains(@class,'main orangehrm-login-button')]")
	WebElement lbtn;

	public String titleFetch() {
		return driver.getTitle();
	}

	public String doLogin(String username, String password) {
		usn.sendKeys(username);
		psw.sendKeys(password);
		lbtn.click();
		return driver.getCurrentUrl();
	}

}
