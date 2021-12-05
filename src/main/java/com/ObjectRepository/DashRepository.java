package com.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashRepository {
	
	@FindBy(xpath ="//*[text()='Java By Kiran']")
	public WebElement DashBoard;
	@FindBy(xpath="//b[text()='Java By Kiran']")
	public WebElement  MainWindowTitle;
	@FindBy(xpath="//h3")
	public List<WebElement> Courses;
	@FindBy(xpath="//*[@class='small-box-footer']")
	public List<WebElement> MoreInfo;
	@FindBy(xpath="//div[@class=\"icon\"]")
	public List<WebElement> Icons;
	@FindBy(xpath ="//span[text()='Users']")
	public WebElement userlink;
	@FindBy(partialLinkText ="info")
	public List<WebElement> infowindows;
}
