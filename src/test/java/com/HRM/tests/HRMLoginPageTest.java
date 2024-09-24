package com.HRM.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HRMLoginPageTest extends BaseClass {

	@Test(priority=1)
	public void titleValidation() {
		Assert.assertTrue(hlp.titleFetch().equalsIgnoreCase("orangehrm"), "Title not matched!");
		System.out.println("Title matched!");
	}

	@Test(priority=2)
	public void loginVerification() {
		String act = hlp.doLogin("Admin", "admin123");
		Assert.assertTrue(act.contains("dashboard"), "Login failed!");
		System.out.println("Login successfull!");
	}
}
