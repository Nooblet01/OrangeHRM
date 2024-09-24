package com.HRM.tests;

import org.testng.annotations.Test;

import com.HRM.util.HRMUtil;

public class HRMAdminPageTest extends BaseClass {

	@Test(priority=1)
	public void verifyDefault() {
		hadp.displayHeaders();
		hadp.displayDefaultRecords();
		HRMUtil.scrollDown(driver);
		HRMUtil.addWait(3000);
		HRMUtil.captureScreen(driver);
	}

	@Test(priority=2)
	public void verifyAdminrecords() {
		hadp.selectUserRole("Admin");
		HRMUtil.addWait(4000);
		hadp.displayRecords();
		HRMUtil.captureScreen(driver);
	}
}
