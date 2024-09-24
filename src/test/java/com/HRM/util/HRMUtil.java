package com.HRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HRMUtil {
	FileInputStream fis;
	Properties p1;

	public HRMUtil() {
		File f1 = new File("./" + "HRM.properties");
		try {
			fis = new FileInputStream(f1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p1 = new Properties();
		try {
			p1.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String propRead(String key) {
		return p1.getProperty(key);
	}

	public static void addWait(long msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void captureScreen(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./" + "\\Snaps\\FinalOrangeHRM" + System.currentTimeMillis() + ".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
