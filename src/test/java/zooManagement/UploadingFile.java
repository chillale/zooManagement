package zooManagement;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadingFile {
	public static void main(String[] args) throws Throwable, ParseException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		FileReader file = new FileReader("./CommonD.json");
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		
		
		
		//here we are creating the object of jsonObject
		JSONParser jsonParser = new JSONParser();
		//here we are parsing the file to object 
		Object object = jsonParser.parse(file);
		//here we are converting the object into key value pair
		HashMap hashMap = (HashMap)object;
		//here we are storing the values
		String uRL=(String) hashMap.get("url");
		driver.get(uRL);
		webDriverUtilityZoo.maximize();
		
		String uName = (String) hashMap.get("username");
		String pWord=(String) hashMap.get("password");
		webDriverUtilityZoo.implicitlyWait();
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(uName);
		
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(pWord);
		
		WebElement loginButton = driver.findElement(By.id("form_submit"));
		loginButton.click(); 
		
		
		WebElement animalDetails = driver.findElement(By.xpath("//span[text()='Animals Details']"));
		animalDetails.click();
		
		WebElement addAnimals = driver.findElement(By.linkText("Add Animals"));
		addAnimals.click();
		
		WebElement animalName = driver.findElement(By.name("aname"));
		animalName.sendKeys("Dog");
		
		WebElement imageofTheAnimal = driver.findElement(By.xpath("//input[@id='image']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", imageofTheAnimal);
		
		Runtime.getRuntime().exec("D://FileUplodad.exe");
		Thread.sleep(3000);
		
	}

}
