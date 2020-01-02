package javaPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class FreeCRM extends BaseClass
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		int wait=10;
		String url = "https://freecrm.com/";
		String ExcelLink = "D:\\Java\\Window7\\Login.xlsx";
		WebDriver driver = getDriver(url);
		implicitWait(wait);
		WebElement LogIn = driver.findElement(By.xpath("//*[text()='Log In']"));
		btnClick(LogIn);
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		Thread.sleep(7000);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		Thread.sleep(7000);
		 String user = Excel(1, 0, ExcelLink);
		 String Pass = Excel(1, 1, ExcelLink);
		type(email, user);
		type(password, Pass);
		WebElement Login = driver.findElement(By.xpath("//*[text()='Login']"));
		btnClick(Login);
		Thread.sleep(3000);
		
	}

}
