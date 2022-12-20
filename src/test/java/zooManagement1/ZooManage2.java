package zooManagement1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertyFile;
import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ZooManage2 {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		PropertyFile propertyFile = new PropertyFile();
		String uRL = propertyFile.readDataFromPropertyFile("url");
		String uName = propertyFile.readDataFromPropertyFile("username");
		String pWord = propertyFile.readDataFromPropertyFile("password");
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		driver.get(uRL);
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(uName);
		
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(pWord);
		
		WebElement loginButton = driver.findElement(By.id("form_submit"));
		loginButton.click();
		
		WebElement searchButton = driver.findElement(By.xpath("//span[text()='Search']"));
		searchButton.click();
		
		WebElement normalTicketSearch = driver.findElement(By.linkText("Normal Ticket Search"));
		normalTicketSearch.click();
		
		WebElement searchData = driver.findElement(By.name("searchdata"));
		searchData.sendKeys("Narayan");
		
		WebElement searchBtn = driver.findElement(By.name("search"));
		searchBtn.click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table text-center']/tbody/tr"));
		for(int i=1;i<=rows.size();i++) {
			for(int j=1;j<=4;j++) {
				String text = driver.findElement(By.xpath("//table[@class='table text-center']/tbody["+i+"]/tr/td[2]")).getText();
				if(text.equals("468362908")) {
				System.out.print(text+" is found at "+i);
				break;
				}
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
