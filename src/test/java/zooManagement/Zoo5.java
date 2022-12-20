package zooManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Zoo5 {
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
		
		WebElement animalDetails = driver.findElement(By.xpath("//span[text()='Animals Details']"));
		animalDetails.click();
		
		WebElement addAnimals = driver.findElement(By.linkText("Add Animals"));
		addAnimals.click();
		
		WebElement animalName = driver.findElement(By.name("aname"));
		animalName.sendKeys("Dog");
		
		WebElement imageButton = driver.findElement(By.id("image"));
		imageButton.click();
		
		webDriverUtilityZoo.switchToParent();
		
		
		
		WebElement cageNumber = driver.findElement(By.id("cnum"));
		cageNumber.sendKeys("11");
		
		WebElement feedNumber = driver.findElement(By.id("fnum"));
	    feedNumber.sendKeys("101");
	    
	    WebElement breedName = driver.findElement(By.id("breed"));
		breedName.sendKeys("Rotwheeler");
		
		WebElement descriptionDetails = driver.findElement(By.id("desc"));
		descriptionDetails.sendKeys("It will bark");
		
		WebElement submitButton = driver.findElement(By.name("submit"));
		submitButton.click();
	}

}
