package zooManagementForeignDetails;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static mapInterface.ForeignersTicketDetails.*;

import genericUtility.BaseClassZoo;
import genericUtility.PropertyFile;
import genericUtility.WebDriverUtilityZoo;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ForeignersTicketClass;
import objectRepository.LoginPageClass;

public class ForeignVisitorTest extends BaseClassZoo{
	@Test(groups = {"system"})
	public void foreignVisitor() throws Throwable {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		PropertyFile propertyFile = new PropertyFile();
//		WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
//		webDriverUtilityZoo.maximize();
//		webDriverUtilityZoo.implicitlyWait();
//		LoginPageClass loginPageTest = new LoginPageClass(driver);
//		loginPageTest.loginDetails(propertyFile.readDataFromPropertyFile("username"),
//				propertyFile.readDataFromPropertyFile("password"));
//		loginPageTest.getSubmitBtn().click();
		ForeignersTicketClass foreignersTicketClass = new ForeignersTicketClass(driver);
		foreignersTicketClass.getForeignersTicketBtn().click();
		foreignersTicketClass.getAddTicketBtn().click();
		foreignersTicketClass.getVisitorName().sendKeys(foreignersDetails().get("visitorName"));
		foreignersTicketClass.getNoOfAdult().sendKeys(foreignersDetails().get("noOfAdult"));
		foreignersTicketClass.getNoOfChildren().sendKeys(foreignersDetails().get("noOfChildren"));
		foreignersTicketClass.getSubmitBtn().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		foreignersTicketClass.getHomeBtn().click();
		

	}

}
