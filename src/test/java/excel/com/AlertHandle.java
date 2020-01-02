package excel.com;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class AlertHandle extends BaseClass 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Java\\Window7\\First\\ExcelSample\\src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.findElement(By.name("cusid")).sendKeys(getData(4, 1));
		driver.findElement(By.name("submit")).submit();
		Thread.sleep(3000);
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();
		
		driver.get("http://demo.guru99.com/popup.php");
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> allwindow = driver.getWindowHandles();
		
		for (String string : allwindow) 
		{
			if (!parent.equals(string)) 
			{
				driver.switchTo().window(string);
				driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(getData(1, 0));
				driver.findElement(By.name("btnLogin")).submit();
				Thread.sleep(3000);
				driver.close();
			}
		}
		
		
		
		
	}

}
