package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.ObjectRepository.LoginRepo;

public class LoginPage extends LoginRepo {
	WebDriver driver;
	
/*@FindBy(id = "email")
	public WebElement email;
	@FindBy(id="password")
	public WebElement pass;
	@FindBy(xpath="//button")
	public WebElement  loginbtn;
	@FindBy(id ="email_error")
	public WebElement emailError;
	@FindBy(id="password_error")
	public WebElement passError;
	@FindBy(linkText = "Sign in to start your session")
	public WebElement SessionStart;
	@FindBy(tagName ="img")
	public WebElement image;
	@FindBy(xpath ="//*[text()='Java By Kiran']")
	public WebElement Title;
	@FindBy(xpath ="//*[text() ='JAVA | SELENIUM | PYTHON']")
	public WebElement Heading;
	@FindBy(xpath ="//b[text()=\"Java By Kiran\"]")
	public WebElement DashboardTitle;
	*/
	private Logger log = Logger.getLogger(LoginPage.class);
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean cheakUrl() {
		String URL = driver.getCurrentUrl();
		log.info("Actual: " + URL);
		String Exp = "file:///E:/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html";
		log.info("Expected: " + Exp);
		if (URL.equals(Exp)) {
			log.info("Right url displayed");
			return true;
		} else {
			log.info("Wrong url displayed");
		}
		return false;
	}
	public boolean FailLoginPassword() {
		pass.clear();
		pass.sendKeys("03594849");
		loginbtn.click();
		String Fail = passError.getText();
		String Exp = "Please enter password as 123456";
		if (Fail.equals(Exp)) {
			log.info("Please enter password as 123456");
			return true;
		} else {
			log.info(Exp);
		return false;
		}
		
	}
	public boolean FailLoginmail() {
		email.clear();
		email.sendKeys("nirmala@gmail.com");
		loginbtn.click();
		String Fail = emailError.getText();
		String Exp = "Please enter email as kiran@gmail.com";
		if (Fail.equals(Exp)) {
			log.info("Please enter email as kiran@gmail.com");
			return true;
		} else {
			log.info(Exp);
		return false;
		}
	}
	public boolean Headline() {
		//WebElement heading = driver.findElement(By.partialLinkText("your session"));
		String actText = SessionStart.getText();
		String ExpText = "Sign in to start your session";
		if (actText.equals(ExpText)) {
			log.info("Page Title is correct");
			return true;
		} else {
			log.info(ExpText);
		return false;
		}
	}
	public String checkmail() {
		WebElement emailBox = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		String act= emailBox.getAttribute("placeholder");
		String exp = "Email";
		return exp;
	}
	public String BlankData() {
		email.clear();
		pass.clear();
		email.sendKeys(" ");
		pass.sendKeys(" ");
		loginbtn.click();
		String Entermail = emailError.getText();
		String Exp = "Please enter email as kiran@gmail.com";
		return Exp;
	}
	public boolean VerifyLogo() {
		boolean actimage = image.isDisplayed();
		if(actimage == true) {
		log.info("Right image displayed ");
		return true;
		}else {
		return actimage;
	}
	
	}
	public boolean verifyHeadline() {
		boolean actText = driver.findElement(By.xpath("//*[text() ='JAVA | SELENIUM | PYTHON']")).isDisplayed();
		log.info("Actual: " + actText);
		String ExpText = "JAVA | SELENIUM | PYTHON";
		if (actText == true) {
			log.info("Right Heading display");
			return true;
		} else {
			return false;
		}
	}
	public RegistrationPage clickOnRegistrationLink(WebDriver driver) {
		driver.findElement(By.partialLinkText("Register")).click();
		return new RegistrationPage(driver);
	}
	public DashBoardPage Validlogin(WebDriver driver) {
		email.clear();
		pass.clear();
		email.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		loginbtn.click();
		String Login = DashboardTitle.getText();
		String Exp ="Java By Kiran";
		return new DashBoardPage(driver);
}
}
