package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{

	static WebDriver driver;
	public static WebDriver getDriver(String url) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Java\\Window7\\First\\ExcelSample\\src\\test\\resources\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void loadurl(String url) 
	{
		driver.get(url);
	}
	
	public static void implicitWait(int a) 
	{
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}
	
	public static void btnClick(WebElement element) 
	{
		element.click();
	}
	
	public static void type(WebElement element, String string) 
	{
		element.sendKeys(string);
	}
	
	public static void quit() 
	{
		driver.quit();
	}
	
	public static String Excel(int row, int col, String link) throws IOException 
	{
		File loc = new File(link);
		FileInputStream f = new FileInputStream(loc);
		XSSFWorkbook w = new XSSFWorkbook(f);
		Sheet s = w.getSheet("Login");
		Row r = s.getRow(row);
		Cell c = r.getCell(col);
		String string = c.toString();
		
		return string;

		
		
	}
	public static String getData(int x, int y) throws IOException 
	{
		File loc = new File("D:\\Java\\Window7\\Login.xlsx");
		FileInputStream fis = new FileInputStream(loc);
		Workbook w  = new XSSFWorkbook(fis);
		Sheet s = w.getSheet("Login");
		Row r = s.getRow(x);
		Cell c = r.getCell(y);
		System.out.println(c);
		CellType ct = c.getCellType();
		String  type = ct.toString();
		System.out.println(type);
		String value = null;
		if (type.equalsIgnoreCase("STRING")) 
		{
			 value = c.getStringCellValue();
		}
		else if(type.equalsIgnoreCase("NUMERIC"))
		{
			if (DateUtil.isCellDateFormatted(c)) 
			{
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				value = sdf.format(dateCellValue);
			}
			else
			{
				double numericCellValue = c.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);
			}
			
		}
		System.out.println(value);
		return value;
	}
	
	
}
