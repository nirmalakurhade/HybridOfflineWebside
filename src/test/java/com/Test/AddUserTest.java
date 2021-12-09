package com.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;

import com.BaseClass.Testbase;
import com.Pages.AddUserPage;
import com.Pages.DashBoardPage;
import com.Pages.LoginPage;
import com.Pages.UserPage;

public class AddUserTest extends Testbase{
	WebDriver driver;
	public LoginPage lp;
	public DashBoardPage dp;
	public UserPage up;
	public AddUserPage ap;
	private Logger log = Logger.getLogger(AddUserTest.class);

	@BeforeMethod
	public void setup() {
		driver= Initialization();
		lp = new LoginPage(driver);
		ap = lp.Validlogin(driver).NavigateUsersPage(driver).clickOnAddUser();
		ExtentReportInitialization();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test//(priority = 1)
	public void VerifyuserpageColumn() {
		Assert.assertEquals(ap.userpageColumn(), true);
	}

	@Test//(priority = 2)
	public void VerifySideBar() {
		Assert.assertEquals(ap.SideBar(), 4);
	}

	@Test//(priority = 3)
	public void CheckURL() {
		Assert.assertEquals(ap.URL(),"file:///E:/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/add_user.html");
	}

	@Test//(priority = 4)
	public void VerifyHeading() {
		Assert.assertEquals(ap.PageTitle(), "Java By Kiran");
	}

	@Test//(priority = 5)
	public void VerifySubmitButton() {
		Assert.assertEquals(ap.SubmitButton(), "Submit");
	}
	@Test//(priority = 6)
	public void validateTitleAfterClickOnCancle() throws Exception {
		up = ap.clickOnCancle();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
}
	@Test//(priority = 7)
	public void VerifyAlertAfterAddUser() throws Exception {
		Assert.assertEquals(ap.adduserdata(),"User Added Successfully. You can not see added user.");
	}
}