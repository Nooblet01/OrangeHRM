package com.HRM.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HRMDashboardPage {
	private WebDriver driver;

	public HRMDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//li")
	List<WebElement> menu;

	public void getMenuOptions() {
		for (WebElement i : menu) {
			System.out.println(i.getText());
		}
	}

	public void selectOption(String option) {
		for (WebElement i : menu) {
			if (i.getText().contains(option)) {
				i.click();
				break;
			}
		}
	}

	public boolean selectOption() {
		for (WebElement i : menu) {
			if (i.getText().contains("Admin")) {
				i.click();
				break;
			}
		}
		return driver.getCurrentUrl().contains("admin");
	}
}
