package zooManagementForeignDetails;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import static mapInterface.ForeignersTicketDetails.*;
import genericUtility.BaseClassZoo;
import objectRepository.ForeignersTicketClass;
import objectRepository.HomePageTest;

public class ForeignVisitor1Test extends BaseClassZoo{
	@Test(groups = {"integration"})
	public void foreignVisitor1() {
		HomePageTest homePageTest = new HomePageTest(driver);
		ForeignersTicketClass  foreignersTicketClass = new ForeignersTicketClass(driver);
		foreignersTicketClass.getForeignersTicketBtn().click();
		foreignersTicketClass.getAddTicketBtn().click();
		foreignersTicketClass.getVisitorName().sendKeys(foreignersDetails().get("visitorName"));
		foreignersTicketClass.getNoOfAdult().sendKeys(foreignersDetails().get("noOfAdult"));
		foreignersTicketClass.getNoOfChildren().sendKeys(foreignersDetails().get("noOfChildren"));
		foreignersTicketClass.getSubmitBtn().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		homePageTest.getHomeBtn().click();
		
		}
	}
