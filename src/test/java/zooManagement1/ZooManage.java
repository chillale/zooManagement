package zooManagement1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.ExcelFile;
import genericUtility.JavaFaker;
import genericUtility.PropertyFile;
import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ZooManage {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		PropertyFile propertyFile = new PropertyFile();
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		String uRL=propertyFile.readDataFromPropertyFile("url");
		String uName=propertyFile.readDataFromPropertyFile("username");
		String pWord=propertyFile.readDataFromPropertyFile("password");
		ExcelFile excelFile  = new ExcelFile();
		String data=excelFile.readDataFromExcel("sheet1", 1, 0);
		String data1=excelFile.readDataFromExcel("sheet1", 1, 1);
		String data2=excelFile.readDataFromExcel("sheet1", 1, 2);
		driver.get(uRL);
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(uName);
		
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(pWord);
		
		WebElement loginButton = driver.findElement(By.id("form_submit"));
		loginButton.click();
		
		WebElement normalTicket = driver.findElement(By.xpath("//span[text()='Normal Ticket']"));
		normalTicket.click();
		
		WebElement addTicket = driver.findElement(By.linkText("Add Ticket"));
		addTicket.click();
		
		WebElement visitorName = driver.findElement(By.id("visitorname"));
		visitorName.sendKeys(data);
		
		WebElement noOfAdult = driver.findElement(By.id("noadult"));
		noOfAdult.sendKeys(data1);
		
		WebElement noOfchildren = driver.findElement(By.id("nochildren"));
		noOfchildren.sendKeys(data2);
		
		WebElement submitButton = driver.findElement(By.name("submit"));
		submitButton.click();
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		WebElement homeButton = driver.findElement(By.linkText("Home"));
		homeButton.click();
		
		WebElement adminButton = driver.findElement(By.xpath("//h4[text()='Admin ']"));
		adminButton.click();
		
		WebElement logOutButton = driver.findElement(By.linkText("Log Out"));
		logOutButton.click();
		
		
		
		
		
	}

}
