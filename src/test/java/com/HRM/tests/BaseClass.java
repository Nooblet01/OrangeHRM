package com.HRM.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.HRM.pages.HRMAdminPage;
import com.HRM.pages.HRMDashboardPage;
import com.HRM.pages.HRMLoginPage;
import com.HRM.util.HRMUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {

	public WebDriver driver;
	public HRMLoginPage hlp;
	public HRMDashboardPage hdp;
	public HRMAdminPage hadp;
	public ExtentReports extent;
    public ExtentSparkReporter spark;
    public ExtentTest test;
    public HRMUtil htl;
	
	@BeforeSuite
	public void reportGen()
	{
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/OrangeHRMReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("BasicReporting");
		extent.attachReporter(spark);
		test = extent.createTest("HybridTest");
	}
	@BeforeTest
	public void browserSetup() {
		htl = new HRMUtil();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(htl.propRead("url"));
		HRMUtil.addWait(4000);
		HRMUtil.captureScreen(driver);
		hlp = PageFactory.initElements(driver, HRMLoginPage.class);
		hdp = PageFactory.initElements(driver, HRMDashboardPage.class);
		hadp = PageFactory.initElements(driver, HRMAdminPage.class);
	}

	@BeforeClass
	public void pageSetup() {
		hlp.doLogin("Admin", "admin123");
		HRMUtil.addWait(4000);
		HRMUtil.captureScreen(driver);
		test.pass("Logged in succesfully!");
		hdp.selectOption("Admin");
	}

	@AfterSuite
	public void tearDown() {
		HRMUtil.addWait(4000);
		extent.flush();
		driver.quit();
	}

}
