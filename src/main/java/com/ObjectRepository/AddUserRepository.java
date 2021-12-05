package com.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserRepository {

	@FindBy(id="username")
	public WebElement uname;
	@FindBy(id="email")
	public WebElement umail;
	@FindBy(id="mobile")
	public WebElement Nomobile;
	@FindBy(id = "course")
	public WebElement usercourse;
	@FindBy(id = "Female")
	public WebElement GenderSelect;
	@FindBy(xpath = "//h3[@class=\"control-sidebar-heading\"]")
	public List<WebElement> NoOfSideBar;
	@FindBy(xpath = "//*[@class=\"col-sm-3 control-label\"]")
	public List<WebElement> userColumn;
	@FindBy(xpath="//b[text()='Java By Kiran']")
	public WebElement  Title;
	@FindBy(xpath="//button")
	public WebElement  submitbtn;
	@FindBy(id = "password")
	public WebElement password;
	@FindBy(xpath = "//*[text()='Friend Mobile']")
	public WebElement MobileNo;
}
