package zooManagement1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertyFile;
import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ZooManage1 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		PropertyFile propertyFile = new PropertyFile();
		String uRL=propertyFile.readDataFromPropertyFile("url");
		String uName=propertyFile.readDataFromPropertyFile("username");
		String pWord=propertyFile.readDataFromPropertyFile("password");
		driver.get(uRL);
		
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(uName);
		
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(pWord);
		
		WebElement loginButton = driver.findElement(By.id("form_submit"));
		loginButton.click();
		
		WebElement reportsButton = driver.findElement(By.xpath("//span[text()='Reports']"));
		reportsButton.click();
		
		WebElement normalPeopleReport = driver.findElement(By.linkText("Normal People Report"));
		normalPeopleReport.click();
		
		WebElement fromDateTf = driver.findElement(By.id("fromdate"));
		fromDateTf.sendKeys("23"+"11"+"2022");
		
		WebElement toDateTf = driver.findElement(By.id("todate"));
		toDateTf.sendKeys("23"+"11"+"2022");
		
		WebElement submitButton = driver.findElement(By.name("submit"));
		submitButton.click();
		
	    List<WebElement> noOfRows = driver.findElements(By.xpath("//table[@class='table text-center']/tbody/tr"));
		System.out.println(noOfRows.size());
		
		for(int i=1;i<=noOfRows.size();i++) {
		       String text=driver.findElement(By.xpath("//table[@class='table text-center']/tbody["+i+"]/tr/td[3]")).getText();
		         if(text.equals("rajesh")) {
		        	 System.out.println(text+" is found at "+i);
		        	 break;
		         }
		
		
		}
		WebElement homeButton = driver.findElement(By.linkText("Home"));
		homeButton.click();
		
		WebElement adminButton = driver.findElement(By.xpath("//h4[text()='Admin ']"));
		adminButton.click();
		
		WebElement logOutButton = driver.findElement(By.linkText("Log Out"));
		logOutButton.click();
	}

}
