package com.stepdefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition extends BaseClass
{
WebDriver driver;
Timeouts implicitlyWait;
@Given("Open guru{int} website")
public void open_guru_website(Integer int1) 
{
	System.setProperty("webdriver.chrome.driver", "D:\\Java\\Window7\\First\\ExcelSample\\src\\test\\resources\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://demo.guru99.com/test/delete_customer.php");
	driver.manage().window().maximize();
	implicitlyWait = driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
}

@When("Enter the details needed")
public void enter_the_details_needed() throws IOException, InterruptedException 
{
	driver.findElement(By.name("cusid")).sendKeys(getData(4, 1));
	driver.findElement(By.name("submit")).submit();
	Thread.sleep(3000);
}

@When("Handle Alert")
public void handle_Alert() 
{
	String text = driver.switchTo().alert().getText();
	System.out.println(text);
	driver.switchTo().alert().accept();
}

@Then("close the website")
public void close_the_website() 
{
	driver.close();
}

	
	
	
}
