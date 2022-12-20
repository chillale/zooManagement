package zooManagementUsingPomClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static mapInterface.HashMapCollections.*;
import genericUtility.ExcelFile;
import genericUtility.PropertyFile;
import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AddAnimalsPageClass;
import objectRepository.LoginPageClass;

public class AddBearTest {
	@Test
	public void addBear() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		PropertyFile propertyFile = new PropertyFile();
		String uRl = propertyFile.readDataFromPropertyFile("url");
		String uName=propertyFile.readDataFromPropertyFile("username");
		String pWord=propertyFile.readDataFromPropertyFile("password");
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		ExcelFile excelFile = new ExcelFile();
		String bearFile=readFileFromHashMap().get("Bear1");
		driver.get(uRl);
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		LoginPageClass loginPageTest = new LoginPageClass(driver);
		loginPageTest.loginDetails(uName, pWord);
		loginPageTest.getSubmitBtn().click();
		AddAnimalsPageClass addAnimalsPageClass = new AddAnimalsPageClass(driver);
		addAnimalsPageClass.getAnimalDetailsBtn().click();
		addAnimalsPageClass.getAddAnimalsBtn().click();
		addAnimalsPageClass.getAnimalNameTf().sendKeys(excelFile.readDataFromExcel("sheet2", 6, 0));
		addAnimalsPageClass.getImagefile().sendKeys(bearFile);
		addAnimalsPageClass.getCageNumberTf().sendKeys(excelFile.readDataFromExcel("sheet2", 5, 2));
		addAnimalsPageClass.getFeedNumberTf().sendKeys(excelFile.readDataFromExcel("sheet2", 5, 3));
		addAnimalsPageClass.getBreedNumber().sendKeys(excelFile.readDataFromExcel("sheet2", 6, 4));
		addAnimalsPageClass.getDescriptionOfAnimal().sendKeys(excelFile.readDataFromExcel("sheet2", 6, 5));
	    addAnimalsPageClass.getSubmitBtn().click();
	    Thread.sleep(2000);
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	    addAnimalsPageClass.getHomeBtn().click();
	    loginPageTest.getAdminBtn().click();
	    loginPageTest.getLogOutBtn().click();
		
		
	}

}
