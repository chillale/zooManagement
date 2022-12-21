package zooManagement1;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.ExcelFile;
import static genericUtility.FakerUtils.*;
import genericUtility.PropertyFile;
import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ZooManage4 {
	
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		PropertyFile propertyFile = new PropertyFile();
		String uRL=propertyFile.readDataFromPropertyFile("url");
		String uName=propertyFile.readDataFromPropertyFile("username");
		String pWord=propertyFile.readDataFromPropertyFile("password");
		
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		ExcelFile excelFile = new ExcelFile();
		String foreignerName=excelFile.readDataFromExcel("sheet1", 3, 0);
		String adultmembers=excelFile.readDataFromExcel("sheet1", 3, 1);
		String childrenMembers=excelFile.readDataFromExcel("sheet1", 3, 2);
		driver.get(uRL);
		
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
		visitorName.sendKeys(foreignerName+foreignerName());
		System.out.println(foreignerName);
		
		WebElement noOfAdult = driver.findElement(By.id("noadult"));
		noOfAdult.sendKeys(adultmembers);
		
		WebElement noOfChildren = driver.findElement(By.id("nochildren"));
		noOfChildren.sendKeys(childrenMembers);
		
		WebElement submitBtn = driver.findElement(By.name("submit"));
		submitBtn.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement reportsButton = driver.findElement(By.xpath("//span[text()='Reports']"));
		reportsButton.click();
		
		WebElement foreignersReport = driver.findElement(By.linkText("Foreigner People Report"));
		foreignersReport.click();
		
		WebElement fromData = driver.findElement(By.id("fromdate"));
		fromData.sendKeys("24"+"11"+"2022");
		
		WebElement toData = driver.findElement(By.id("todate"));
		toData.sendKeys("24"+"11"+"2022");
		
		WebElement submitButto = driver.findElement(By.name("submit"));
		submitButto.click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table text-center']/tbody/tr"));
		System.out.println(rows.size());
		
		for(int i=1;i<=rows.size();i++) {
			for(int j=1;j<=4;j++) {
				WebElement rowData = driver.findElement(By.xpath("//table[@class='table text-center']/tbody["+i+"]/tr/td["+j+"]"));
				String singleRow = rowData.getText();
				System.out.print(singleRow+" ");
			}
			System.out.println();
		}
		
		WebElement homeButton = driver.findElement(By.linkText("Home"));
		homeButton.click();
		
		WebElement adminButton = driver.findElement(By.xpath("//h4[text()='Admin ']"));
		adminButton.click();
		
		WebElement logOutButton = driver.findElement(By.linkText("Log Out"));
		logOutButton.click();
		
		
		
		
	}
}
