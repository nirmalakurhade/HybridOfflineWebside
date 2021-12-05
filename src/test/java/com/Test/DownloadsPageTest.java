package com.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import com.BaseClass.Testbase;
import com.Pages.DashBoardPage;
import com.Pages.DownloadsPage;
import com.Pages.LoginPage;

public class DownloadsPageTest extends Testbase {
	WebDriver driver;
	public LoginPage lp;
	public DashBoardPage dp;
	public DownloadsPage dl;
	@BeforeMethod
	public void setup() {
		driver = Initialization();
		lp = new LoginPage(driver);
	    dl = lp.Validlogin(driver).NavigateDownloadsPage(driver);
	    ExtentReportInitialization();
}
	@Test
	public void Verify32bitusers() {
		Assert.assertEquals(dl.bitusers(), false);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
}
}