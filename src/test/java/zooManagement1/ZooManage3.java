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

public class ZooManage3 {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		PropertyFile propertyFile = new PropertyFile();
		String uRL=propertyFile.readDataFromPropertyFile("url");
		String uName=propertyFile.readDataFromPropertyFile("username");
		String pWord=propertyFile.readDataFromPropertyFile("password");
		ExcelFile excelFile=new ExcelFile();
		String data=excelFile.readDataFromExcel("sheet1", 2, 0);
		String data1 = excelFile.readDataFromExcel("sheet1", 2, 1);
		String data2=excelFile.readDataFromExcel("sheet1", 2, 2);
		String foreignerName = JavaFaker.foreignerName();
		
		driver.get(uRL);
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(uName);
		
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(pWord);
		
		WebElement loginButton = driver.findElement(By.id("form_submit"));
		loginButton.click();
		
		WebElement foreignersTicket = driver.findElement(By.xpath("//span[text()='Foreigners Ticket']"));
		foreignersTicket.click();
		
		WebElement addTicketButton = driver.findElement(By.linkText("Add Ticket"));
		addTicketButton.click();
		
		WebElement visitorName = driver.findElement(By.id("visitorname"));
		visitorName.sendKeys(foreignerName);
		System.out.println(foreignerName);
		
		WebElement noOfAdult = driver.findElement(By.id("noadult"));
		noOfAdult.sendKeys(data1);
		
		WebElement noOfChildren = driver.findElement(By.id("nochildren"));
		noOfChildren.sendKeys(data2);
		
		WebElement submitBtn = driver.findElement(By.name("submit"));
		submitBtn.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement adminButton = driver.findElement(By.xpath("//h4[text()='Admin ']"));
		adminButton.click();
		
		WebElement logOutButton = driver.findElement(By.linkText("Log Out"));
		logOutButton.click();
		
		
	}

}
