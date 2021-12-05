package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OperatorsPage {
 WebDriver driver;
 public LoginPage lp;
 static DashBoardPage dp;
 OperatorsPage op;
	public OperatorsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
