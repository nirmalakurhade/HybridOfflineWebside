package com.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRepository {

	@FindBy(xpath ="//b[text()='Java By Kiran']")
	public WebElement OnUserpage;
	@FindBy(xpath ="//a[@target=\"_blank\"]")
	public WebElement HomeUrl;
	@FindBy(xpath ="//*[text()=\"Certified Software Developer\"]")
	public WebElement Text;
	@FindBy(xpath ="/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")
	public WebElement Adduserlink;
	@FindBy(xpath="//th")
	public List<WebElement> NoOfColumn;
	@FindBy(xpath="//*[text()='Maharashtra']")
	public List<WebElement> NoOfState;
}
