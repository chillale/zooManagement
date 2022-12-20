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

public class AddGirafeeTest {
	@Test
	public void addGirafeetoAnimals() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		PropertyFile propertyFile = new PropertyFile();
		String uRL=propertyFile.readDataFromPropertyFile("url");
		String uName=propertyFile.readDataFromPropertyFile("username");
		String pWord=propertyFile.readDataFromPropertyFile("password");
        WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
        driver.get(uRL);
        webDriverUtilityZoo.maximize();
        webDriverUtilityZoo.implicitlyWait();
        ExcelFile excelFile = new ExcelFile();
        LoginPageClass loginPageTest = new LoginPageClass(driver);
        loginPageTest.loginDetails(uName, pWord);
        loginPageTest.getSubmitBtn().click();
        AddAnimalsPageClass addAnimalsPageClass = new AddAnimalsPageClass(driver);
       
        addAnimalsPageClass.getAnimalDetailsBtn().click();
        addAnimalsPageClass.getAddAnimalsBtn().click();
        addAnimalsPageClass.getAnimalNameTf().sendKeys(excelFile.readDataFromExcel("sheet2", 10, 0));
        addAnimalsPageClass.getImagefile().sendKeys(readFileFromHashMap().get("Girafee"));
        addAnimalsPageClass.getCageNumberTf().sendKeys(excelFile.readDataFromExcel("sheet2", 10, 2));
        addAnimalsPageClass.getFeedNumberTf().sendKeys(excelFile.readDataFromExcel("sheet2", 10, 3));
        addAnimalsPageClass.getBreedNumber().sendKeys(excelFile.readDataFromExcel("sheet2", 10, 4));
        addAnimalsPageClass.getDescriptionOfAnimal().sendKeys(excelFile.readDataFromExcel("sheet2", 10, 5));
        addAnimalsPageClass.getSubmitBtn().click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        addAnimalsPageClass.getHomeBtn().click();
        loginPageTest.getAdminBtn().click();
        loginPageTest.getLogOutBtn().click();
        
		
	}

}
