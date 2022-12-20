package zooManagementUsingPomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.ExcelFile;
import genericUtility.PropertyFile;
import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AddAnimalsPageClass;
import objectRepository.LoginPageClass;
import static mapInterface.HashMapCollections.*;
public class AddPeacockTest {
	@Test
	public void addPeacockTest() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		PropertyFile propertyFile = new PropertyFile();
		String uRL=propertyFile.readDataFromPropertyFile("url");
		String uName=propertyFile.readDataFromPropertyFile("username");
		String pWord=propertyFile.readDataFromPropertyFile("password");
		ExcelFile excelFile = new ExcelFile();
		
		driver.get(uRL);
		LoginPageClass loginPageTest = new LoginPageClass(driver);
		loginPageTest.loginDetails(uName, pWord);
		loginPageTest.getSubmitBtn().click();
		AddAnimalsPageClass addAnimalsPageClass = new AddAnimalsPageClass(driver);
		addAnimalsPageClass.getAnimalDetailsBtn().click();
		addAnimalsPageClass.getAddAnimalsBtn().click();
		addAnimalsPageClass.getAnimalNameTf().sendKeys(excelFile.readDataFromExcel("sheet2", 9, 0));
		addAnimalsPageClass.getImagefile().sendKeys(readFileFromHashMap().get(""));
		
	}

}
