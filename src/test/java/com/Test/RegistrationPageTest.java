package com.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import com.BaseClass.Testbase;
import com.Pages.LoginPage;
import com.Pages.RegistrationPage;


public class RegistrationPageTest extends Testbase{

	public WebDriver driver;
	public RegistrationPage rp;
	public LoginPage lp;
	private Logger log = Logger.getLogger(Testbase.class);
	
	@BeforeMethod
	public void setup() {
		driver= Initialization();
		lp = new LoginPage(driver);
		rp=lp.clickOnRegistrationLink(driver);
		ExtentReportInitialization();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	@Test(priority=1)
	public void checkAlreadyMembershipLink() {
		
		lp=rp.clickOnAlreadyMembership();
		
		String act = driver.getTitle();
		String exp = "JavaByKiran | Log in";
		Assert.assertEquals(act, exp);
	}
	@Test(priority = 2)
	public void FillRegistrationForm() {
		boolean status=	rp.registrationForm();
		Assert.assertTrue(status);
	}
}
