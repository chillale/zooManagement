package zooManagement1;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ZooManage5 {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//here we are converting the physical file into java object
		FileReader fileReader = new FileReader("./CommonD.json");
		//here we are creating the object of jsonparser
		JSONParser jsonParser = new JSONParser();
		//here we are parsing the file into object
		Object object = jsonParser.parse(fileReader);
		//here we are converting the object into hashMap to get the values in key value pair
		
		HashMap hashMap = (HashMap)object;
		//here we are reading the url from jsonObject
		String uRL=(String)hashMap.get("url");
		//here we are reading the username from jsonObject
		String uName=(String)hashMap.get("username");
		//here we are reading the password from jsonObject
		String pWord=(String)hashMap.get("password");
		
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		
		driver.get(uRL);
		
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(uName);
		
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(pWord);
		
		 
		
		WebElement searchButton = driver.findElement(By.xpath("//span[text()='Search']"));
		searchButton.click();
		
	    WebElement foreignerTicketSearch = driver.findElement(By.linkText("Foreigner Ticket Search"));
	    foreignerTicketSearch.click();
	    
	    WebElement foreignerName = driver.findElement(By.name("searchdata"));
	    foreignerName.sendKeys("steve");
	    
	    WebElement searchBtn = driver.findElement(By.name("search"));
	    searchBtn.click();
	    
	    List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table text-center']/tbody/tr"));
	    for(int i=1;i<=rows.size();i++) {
	    	WebElement foreignName=driver.findElement(By.xpath("//table[@class='table text-center']/tbody["+i+"]/tr/td[3]"));
	    	String foreignervisitorName = foreignName.getText();
	    	if(foreignervisitorName.equals("steve Moises")) {
	    		System.out.println(foreignervisitorName+" "+"is found at index"+i);
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
