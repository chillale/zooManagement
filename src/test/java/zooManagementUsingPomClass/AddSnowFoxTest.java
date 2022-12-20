package zooManagementUsingPomClass;
import static mapInterface.HashMapCollections.*;

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

public class AddSnowFoxTest {
	@Test
	public void addSnow() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		PropertyFile propertyFile = new PropertyFile();
		ExcelFile excelFile = new ExcelFile();
		WebDriverUtilityZoo webdriverUtilityZoo = new WebDriverUtilityZoo(driver);
		driver.get(propertyFile.readDataFromPropertyFile("url"));
		webdriverUtilityZoo.maximize();
		webdriverUtilityZoo.implicitlyWait();
		LoginPageClass loginPageTest = new LoginPageClass(driver);
		loginPageTest.loginDetails(propertyFile.readDataFromPropertyFile("username"), propertyFile.readDataFromPropertyFile("password"));
		loginPageTest.getSubmitBtn().click();
		AddAnimalsPageClass addAnimalsPageClass = new AddAnimalsPageClass(driver);
		addAnimalsPageClass.getAnimalDetailsBtn().click();
		addAnimalsPageClass.getAddAnimalsBtn().click();
		addAnimalsPageClass.getAnimalNameTf().sendKeys(excelFile.readDataFromExcel("sheet2", 11, 0));
        addAnimalsPageClass.getImagefile().sendKeys(readFileFromHashMap().get("Snowfox"));
        addAnimalsPageClass.getCageNumberTf().sendKeys(excelFile.readDataFromExcel("sheet2", 11, 2));
        addAnimalsPageClass.getFeedNumberTf().sendKeys(excelFile.readDataFromExcel("sheet2", 11, 3));
        addAnimalsPageClass.getBreedNumber().sendKeys(excelFile.readDataFromExcel("sheet2", 11, 4));
        addAnimalsPageClass.getDescriptionOfAnimal().sendKeys(excelFile.readDataFromExcel("sheet2", 11, 5));
        addAnimalsPageClass.getSubmitBtn().click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        addAnimalsPageClass.getHomeBtn().click();
        loginPageTest.getAdminBtn().click();
        loginPageTest.getLogOutBtn().click();
		
	}

}
