package zooManagement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Zoo4 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Zoo_Management_System/admin/index.php");
		
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("admin");
		
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys("Test@123");
		
		WebElement submitBtn = driver.findElement(By.id("form_submit"));
		submitBtn.click();
		
		WebElement normalTicketButton = driver.findElement(By.xpath("//span[text()='Normal Ticket']"));
		normalTicketButton.click();
		
		WebElement addTicketButton = driver.findElement(By.linkText("Add Ticket"));
		addTicketButton.click();
		
		WebElement visitorName = driver.findElement(By.id("visitorname"));
		visitorName.sendKeys("nallababu");
		
		WebElement noOfAdult = driver.findElement(By.id("noadult"));
	    noOfAdult.sendKeys("3");
	    
	    WebElement noOfChildren = driver.findElement(By.id("nochildren"));
	    noOfChildren.sendKeys("5");
	    
	    WebElement submitButton = driver.findElement(By.name("submit"));
	    submitButton.click();
	    
	    Alert alert=driver.switchTo().alert();
	    alert.accept();
	    
	    WebElement homeButton = driver.findElement(By.linkText("Home"));
	    homeButton.click();
	
	    WebElement adminButton = driver.findElement(By.xpath("//h4[text()='Admin ']"));
	    adminButton.click();
	    
	    WebElement logoutButton = driver.findElement(By.linkText("Log Out"));
	    logoutButton.click();
	    
	}

}
