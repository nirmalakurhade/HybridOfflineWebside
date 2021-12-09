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

public class UserTest extends Testbase {
  WebDriver driver;
  public LoginPage lp;
  public DashBoardPage dp;
  public UserPage up;
  public AddUserPage ap;
  private Logger log = Logger.getLogger(UserTest.class);
  @BeforeMethod
	public void setup() {
	    driver= Initialization();
		lp = new LoginPage(driver);
		up = lp.Validlogin(driver).NavigateUsersPage(driver);
		ExtentReportInitialization();
		
  }

@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test//(priority = 2)
	public void VerifyHeading() {
	Assert.assertEquals(up.Heading(),"Java By Kiran");
	}
	@Test//(priority = 3)
    public void CheckColumnTitle() {
    	Assert.assertEquals(up.ColumnTitle(), true);
    }
	@Test//(priority = 4)
	public void CorrectStateSelected() {
		Assert.assertEquals(up.StateSelected(),2);
	}
	
	@Test//(priority = 5)
	public void CheckAlertHandle() throws Exception {
		Assert.assertEquals(up.AlertHandle(),"You can not delete Default User");
	}
	
	@Test //(priority = 6)
	public void ListTitle() {
		Assert.assertEquals(up.ListTitle(),true);
	}
	/*@Test (priority = 7)
	public void VerifyMaleUsers() {
		Assert.assertEquals(up.TotalMaleUsers(),true);
	}
	/*@Test (priority = 8)
	public void VerifyFemaleUsers() throws Exception {
		Assert.assertEquals(up.TotalFemaleUsers(),true);
	}
	@Test (priority = 9)
	public void VerifygmailUsers() {
		Assert.assertEquals(up.TotalGmailUsers(),true);
	}*/
	@Test //(priority = 10)
	public void VerifyMobileNo() throws Exception {
		Assert.assertEquals(up.CheckMobileNo(),true);
	}
	/*@Test (priority = 11)
	public void VerifyHomePageUrl() throws Exception {
		Assert.assertEquals(up.GetHomepageUrl(),true);
	}*/
	@Test//(priority = 12)
	public void clickAddUserPage() {
		ap=up.clickOnAddUser();
		String act = driver.getTitle();
		String exp = "JavaByKiran | Add User";
		Assert.assertEquals(act, exp);
	}
	
}

