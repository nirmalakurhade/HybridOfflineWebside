package com.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRepo {

	@FindBy(id = "email")
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
}
