package com.HRM.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRM.util.HRMUtil;

public class HRMDashboardPageTest extends BaseClass {
	@Test(priority = 1)
	public void printOptions() {
		hdp.getMenuOptions();
	}

	@Test(priority = 2)
	public void verifySelection() {
		Assert.assertTrue(hdp.selectOption(), "Failed to redirect");
		System.out.println("Succesfully redirected!");
		HRMUtil.addWait(4000);
		HRMUtil.captureScreen(driver);
	}
}
