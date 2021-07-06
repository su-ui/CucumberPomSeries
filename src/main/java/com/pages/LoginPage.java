package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1. By locators
	
	private By emailId = By.id("email");
	
	private By password = By.id("passwd");
	
	private By signInButton = By.id("SubmitLogin");
	
	//private By forgotPasswrdLink = By.linkText("Forgot your password?");
	
	private By passwordLink = By.xpath("//a[@title='Recover your forgotten password']");
	
	//2. constructor of the page class
	
	public LoginPage(WebDriver driver)
	{
		 this.driver = driver;
	}
	
	//3. Page action
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkExist() throws InterruptedException
	{
		//Thread.sleep(3000);
		return driver.findElement(passwordLink).isDisplayed();
	}
	
	public void enterUserName(String username)
	{
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassWord(String pwd )
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(signInButton).click();
	}

	
	
	public AccountsPage doLogin(String un,String pwd)
	
	{
		
		System.out.println("Login with "+un+"  and  "+pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		
		return new AccountsPage(driver);
	}
}
