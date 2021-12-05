package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.Testbase;
import com.Pages.DashBoardPage;
import com.Pages.DownloadsPage;
import com.Pages.LoginPage;
import com.Pages.OperatorsPage;
import com.Pages.UserPage;

public class DashBoardTest extends Testbase{

	WebDriver driver;
	public LoginPage lp;
	public DashBoardPage dp;
    public UserPage up;
    public OperatorsPage op;
	public DownloadsPage dl;
	
    @BeforeMethod
	public void setup() {
    	driver= Initialization();
		lp = new LoginPage(driver);
		dp = lp.Validlogin(driver);
		ExtentReportInitialization();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	@Test(priority = 1)
	public void CheckTotalinnerBox() {
		Assert.assertEquals(dp.TotalinnerBox(), 4);
	}

	@Test(priority = 2)
	public void ValidDashboardPage() {
		Assert.assertEquals(dp.DashboardPage(), "Java By Kiran");
	}

	@Test(priority = 3)
	public void CheckTotalCourses() {
		Assert.assertEquals(dp.TotalCourses(), true);
	}

	@Test(priority = 4)
	public void TotalMoreInfoLink() {
		Assert.assertEquals(dp.TotalMoreInfoLink(), 4);
	}

	@Test(priority = 5)
	public void WindowHandeling() throws Exception {
		Assert.assertEquals(dp.WindowHandeling(), null);
	}

	@Test(priority = 6)
	public void NoOfIcons() {
		Assert.assertEquals(dp.NoOfIcons(), 4);
}

	@Test(priority = 7)
	public void checkUsersLinkMenu() {
		up = dp.NavigateUsersPage(driver);
		String act = driver.getTitle();
		String exp = "JavaByKiran | User";
		Assert.assertEquals(act, exp);
	}

	@Test(priority = 8)
	public void checkOperatorsLinkMenu() {
		op = dp.NavigateOperatorsPage(driver);
		String act = driver.getTitle();
		String exp = "JavaByKiran | Operators";
		Assert.assertEquals(act, exp);

	}

	@Test(priority = 9)
	public void checkDownloadsLinkMenu() {
		dl = dp.NavigateDownloadsPage(driver);
		String act = driver.getTitle();
		String exp = "JavaByKiran | Downloads";
		Assert.assertEquals(act, exp);
	}

	@Test(priority = 10)
	public void checkLogoutLinkMenu() {
		lp = dp.NavigateLogoutPage(driver);
		String act = driver.getTitle();
		String exp = "JavaByKiran | Log in";
		Assert.assertEquals(act, exp);
	}

}