package zooManagementVisitorDetails;
import static mapInterface.VisitorDetails.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.PropertyFile;
import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AddTicketPageClass;
import objectRepository.LoginPageClass;
import objectRepository.NormalTicketPageTest;
import objectRepository.VisitorPage;

public class VisitorETest {
	@Test
	public void visitor1() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		PropertyFile propertyFile = new PropertyFile();
		driver.get(propertyFile.readDataFromPropertyFile("url"));
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		LoginPageClass loginPageTest = new LoginPageClass(driver);
		loginPageTest.getUserNameTf().sendKeys(propertyFile.readDataFromPropertyFile("username"));
		loginPageTest.getPassWordTf().sendKeys(propertyFile.readDataFromPropertyFile("password"));
		loginPageTest.getSubmitBtn().click();
		VisitorPage visitorPage = new VisitorPage(driver);
		NormalTicketPageTest normalTicketPageTest = new NormalTicketPageTest(driver);
		normalTicketPageTest.getNormalTicketBtn().click();
		normalTicketPageTest.getAddTicketBtn().click();
		visitorPage.getVisitorName().sendKeys(readVisitorDetails().get("visitorName"));
		visitorPage.getNoOfAdult().sendKeys(readVisitorDetails().get("noOfAdult"));
		visitorPage.getNoOfChildren().sendKeys(readVisitorDetails().get("noOfChildren"));
		//loginPageTeSubmitBtn().click();
		new AddTicketPageClass(driver).getSubmitBtn().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		loginPageTest.getAdminBtn().click();
		loginPageTest.getLogOutBtn().click();
		
		
	}

}
