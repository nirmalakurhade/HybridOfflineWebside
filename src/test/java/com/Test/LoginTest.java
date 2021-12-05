package com.Test;

import org.testng.annotations.Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.BaseClass.Testbase;
import com.Pages.AddUserPage;
import com.Pages.DashBoardPage;
import com.Pages.LoginPage;
import com.Pages.RegistrationPage;
import com.Pages.UserPage;

public class LoginTest extends Testbase {
	WebDriver driver;
	
	public LoginPage lp;
    public DashBoardPage dp;
    public UserPage up;
    public AddUserPage ap;
    public RegistrationPage rp;
    private Logger log= Logger.getLogger(LoginTest.class);
    
    
	@BeforeMethod
	public void setup() {
		driver = Initialization();
		lp = new LoginPage(driver);
		ExtentReportInitialization();
	}
   @AfterMethod
	public void Fire(){
		driver.close();
	}
   
   @Test(priority = 1)
	public void ValidetUrl() {
		Assert.assertEquals(lp.cheakUrl(), true);
	}

	@Test(priority = 2)
	public void PasswordError() {
		String Fail = driver.getTitle();
		log.info(Fail);
		Assert.assertEquals(lp.FailLoginPassword(),false);
	}

	@Test(priority = 3)
	public void mailError() {
		Assert.assertEquals(lp.FailLoginmail(),true);
	}
/*
	@Test(priority = 4)
	public void Checkheading() {
		Assert.assertEquals(lp.Headline(), true);
	}
*/
	@Test(priority = 5)
	public void Checkmailbox() {
		Assert.assertEquals(lp.checkmail(), "Email");
	}

	@Test(priority = 6)
	public void Checkblankmail() {
		Assert.assertEquals(lp.BlankData(), "Please enter email as kiran@gmail.com");
	}

	@Test(priority = 7)
	public void validateImage() {
		Assert.assertEquals(lp.VerifyLogo(), true);
	}

	@Test(priority = 8)
	public void CheckHeading() {
		Assert.assertEquals(lp.verifyHeadline(), true);
	}
	@Test(priority = 9)
	public void checkRegistrationLink() {
		rp = lp.clickOnRegistrationLink(driver);
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Registration Page");
	}
	@Test(priority = 10)
	public void test10() {
		dp = lp.Validlogin(driver);
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard");
	}
}