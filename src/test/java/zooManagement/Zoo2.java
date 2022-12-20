package zooManagement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.JavaFaker;
import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Zoo2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		
		driver.get("http://rmgtestingserver/domain/Zoo_Management_System/admin/index.php");
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("admin");
		
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys("Test@123");
		
		WebElement submitBtn = driver.findElement(By.id("form_submit"));
		submitBtn.click();
		
		WebElement animalDetails = driver.findElement(By.xpath("//span[text()='Animals Details']"));
		animalDetails.click();
		
		WebElement addAnimalsBtn = driver.findElement(By.xpath("//a[text()='Add Animals']"));
		addAnimalsBtn.click();
		
		WebElement foreignersTicketBtn = driver.findElement(By.xpath("//span[text()='Foreigners Ticket']"));
		foreignersTicketBtn.click();
		
		WebElement addTicketbtn = driver.findElement(By.linkText("Add Ticket"));
		addTicketbtn.click();
		
//		String pHadle=webDriverUtilityZoo.switchToParent();
//		webDriverUtilityZoo.allHandles(pHadle);
		
		WebElement visitorName = driver.findElement(By.id("visitorname"));
		visitorName.sendKeys(""+JavaFaker.foreignerName());
		
		WebElement noOfAdult = driver.findElement(By.id("noadult"));
		noOfAdult.sendKeys(""+JavaFaker.randomNumber());
		
		WebElement noOfChildren = driver.findElement(By.id("nochildren"));
		noOfChildren.sendKeys(""+JavaFaker.randomNumber());
		
		WebElement submitButton = driver.findElement(By.name("submit"));
		submitButton.click();
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		WebElement homePage = driver.findElement(By.xpath("//a[text()='Home']"));
		homePage.click();
		
		WebElement adminBtn = driver.findElement(By.xpath("//h4[text()='Admin ']"));
		adminBtn.click();
		
		WebElement logOutBtn = driver.findElement(By.linkText("Log Out"));
		logOutBtn.click();
		
		
	}
	

}
