package zooManagementUsingPomClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.ExcelFile;
import  genericUtility.PropertyFile;

import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AddAnimalsPageClass;
import objectRepository.HomePageTest;
import objectRepository.LoginPageClass;

public class AddAnimalsTest {
	@Test
	public void addAnimals() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		PropertyFile propertyFile = new PropertyFile();
		String uRL=propertyFile.readDataFromPropertyFile("url");
		String uName=propertyFile.readDataFromPropertyFile("username");
		String pword=propertyFile.readDataFromPropertyFile("password");
		ExcelFile excelFile = new ExcelFile();
		String animalName=excelFile.readDataFromExcel("sheet2", 2, 0);
		String animalFile=excelFile.readDataFromExcel("sheet2", 2, 1);
		String cageNumber = excelFile.readDataFromExcel("sheet2", 2, 2);
		String feedNumber=excelFile.readDataFromExcel("sheet2", 2, 3);
		String breedName = excelFile.readDataFromExcel("sheet2", 2, 4);
		String description=excelFile.readDataFromExcel("sheet2", 2, 5);
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		driver.get(uRL);
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
//		HomePageTest homePageTest = new HomePageTest(driver);
//		homePageTest.getAdminBtn().click();
		
		LoginPageClass loginPageTest = new LoginPageClass(driver);
		loginPageTest.loginDetails(uName, pword);
		loginPageTest.getSubmitBtn().click();
	    AddAnimalsPageClass addAnimalsPageClass = new AddAnimalsPageClass(driver);
	    addAnimalsPageClass.getAnimalDetailsBtn().click();
	    addAnimalsPageClass.getAddAnimalsBtn().click();
	    addAnimalsPageClass.getAnimalNameTf().sendKeys(animalName);
	    addAnimalsPageClass.getImagefile().sendKeys(animalFile);
	    addAnimalsPageClass.getCageNumberTf().sendKeys(cageNumber);
	    addAnimalsPageClass.getFeedNumberTf().sendKeys(feedNumber);
	    addAnimalsPageClass.getBreedNumber().sendKeys(breedName);
	    addAnimalsPageClass.getDescriptionOfAnimal().sendKeys(description);
	    addAnimalsPageClass.getSubmitBtn().click();
	    Alert alert = driver.switchTo().alert();
	    alert.accept();	
	    Thread.sleep(3000);
	    addAnimalsPageClass.getHomeBtn().click();
	    loginPageTest.getAdminBtn().click();
	    loginPageTest.getLogOutBtn().click();
	    
	   
		
	}


}
      