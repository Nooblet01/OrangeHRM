package com.HRM.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HRMAdminPage {

	private WebDriver driver;

	public HRMAdminPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "(//div[@class='oxd-select-text--after'])[1]")
	WebElement uRole;

	@FindBy(xpath = "//div[@class='oxd-select-option']//span")
	List<WebElement> uOpts;

	@FindBy(xpath = "(//div[@class='oxd-select-text--after'])[2]")
	WebElement uStat;

	@FindBy(xpath = "//div[@class='oxd-select-option']//span")
	List<WebElement> stOpts;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement sBtn;

	@FindBy(xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border']")
	List<WebElement> records;

	@FindBy(xpath = "//button[normalize-space()='Reset']")
	WebElement rBtn;

	@FindBy(xpath = "//div[@class='oxd-table-header']//div[@role='columnheader']")
	List<WebElement> headers;

	@FindBy(xpath = "(//div[@class='oxd-table-header']//div[@role='columnheader']//i)[8]")
	WebElement sortDown;

	@FindBy(xpath = "//div[@class='--active oxd-table-header-sort-dropdown']//li//span[@class='oxd-text oxd-text--span']")
	List<WebElement> ddOpts;

	public void displayDefaultRecords() {
		System.out.println("Number of Total records found: " + records.size());
		for (int i = 0; i < records.size(); i++) {
			System.out.println(records.get(i).getText());
		}
	}

	public void displayHeaders() {
		for (WebElement i : headers) {
			System.out.println(i.getText());
		}
	}

	public void selectUserRole(String option) {
		uRole.click();
		for (WebElement i : uOpts) {
			if (i.getText().contains(option)) {
				i.click();
				break;
			}
		}
	}

	public void displayRecords() {
		sBtn.click();
		System.out.println("Number of Total records found: " + records.size());
		for (int i = 0; i < records.size(); i++) {
			System.out.print(records.get(i).getText());
		}
		System.out.println();
	}
}
