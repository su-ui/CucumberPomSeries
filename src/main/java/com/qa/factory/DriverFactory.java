package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	 
	
	
	public WebDriver driver; 
	
	
	
	//To execute in the parallel mode we have to use ThreadLocal.Its a Java feature
	//Create a Thread local instance, with WebDriver generics
	//initialize webdriver with thread local
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	//create a method which will initialize the webdriver based on browser property
	
	public WebDriver init_driver(String browser)
	{
		
		System.out.println("browser value is :"+ browser);
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			//ThreadLocalDriver will give get and set method
			//here objcet of new ChromeDriver set with tlDriver
			//It will create a copy with threadLocal driver
			//here chromedriver will set with threadlocal driver, threadlocal driver will have a copy of Webdriver
			
			tlDriver.set(new ChromeDriver());
			
			
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("safari"))
		{
			
			tlDriver.set(new SafariDriver());
		}
		else {
			System.out.println("Please pass the correct browser value"+browser);
		}
		
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	getDriver().manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	
	return getDriver();
		
	}

	
	
	
	//this method will return thread local instance, whatever threadlocal is initialized to
	//If there are 5 threads all the threads should be in sync, so use synchronized keyword
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	
	
}
