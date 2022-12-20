package zooManagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Zoo3 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
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
		
		WebElement searchBtn = driver.findElement(By.xpath("//span[text()='Search']"));
		searchBtn.click();
		
		WebElement normalTicketSearch = driver.findElement(By.xpath("//a[text()='Normal Ticket Search']"));
		normalTicketSearch.click();
		
		WebElement searchData = driver.findElement(By.name("searchdata"));
		searchData.sendKeys("Anusuya");
		
		WebElement submitButton = driver.findElement(By.id("submit"));
		submitButton.click();
		
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='table text-center']/tbody/tr"));
	System.out.println(table.size());
		for(int i=1;i<table.size();i++) {
			for(int j=1;j<=4;j++) {
				String text =   driver.findElement(By.xpath("//table[@class='table text-center']/tbody["+i+"]/tr/td["+j+"]")).getText();
				System.out.print(text);
			}
			System.out.println();
		}
		WebElement homeButton = driver.findElement(By.xpath("//a[text()='Home']"));
		homeButton.click();
		
		WebElement adminButton = driver.findElement(By.xpath("//h4[text()='Admin ']"));
		adminButton.click();
		
		WebElement logoutButton = driver.findElement(By.linkText("Log Out"));
		logoutButton.click();
		
	}

}
