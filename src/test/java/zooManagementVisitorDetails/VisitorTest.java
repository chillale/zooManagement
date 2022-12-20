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

public class VisitorTest{
	@Test
	public void visitorDetails() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		PropertyFile propertyFile = new PropertyFile();
		driver.get(propertyFile.readDataFromPropertyFile("url"));
		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		LoginPageClass loginPageTest = new LoginPageClass(driver);
		loginPageTest.loginDetails(propertyFile.readDataFromPropertyFile("username"), propertyFile.readDataFromPropertyFile("password"));
		loginPageTest.getSubmitBtn().click();
		NormalTicketPageTest normalTicketPageTest = new NormalTicketPageTest(driver);
		normalTicketPageTest.getNormalTicketBtn().click();
		normalTicketPageTest.getAddTicketBtn().click();
		VisitorPage visitorPage = new VisitorPage(driver);
		visitorPage.getVisitorName().sendKeys(readVisitorDetails().get("visitorName"));
		visitorPage.getNoOfAdult().sendKeys(readVisitorDetails().get("noOfAdult"));
		visitorPage.getNoOfChildren().sendKeys(readVisitorDetails().get("noOfChildren"));
		new AddTicketPageClass(driver).getSubmitBtn().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		loginPageTest.getAdminBtn().click();
		loginPageTest.getLogOutBtn().click();
	}

}
