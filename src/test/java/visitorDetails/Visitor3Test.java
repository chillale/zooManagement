package visitorDetails;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import genericUtility.BaseClassZoo;

import static mapInterface.VisitorDetails.*;
import objectRepository.VisitorPage;

public class Visitor3Test extends BaseClassZoo{
	@Test(groups = "integration")
	public void visitor3() throws Throwable {
		VisitorPage visitorPage = new VisitorPage(driver);
		visitorPage.getNormalTicketBtn().click();
		visitorPage.getAddTicketBtn().click();
		visitorPage.getVisitorName().sendKeys(readVisitorDetails().get("visitorName"));
		visitorPage.getNoOfAdult().sendKeys(readVisitorDetails().get("noOfAdult"));
		visitorPage.getNoOfChildren().sendKeys(readVisitorDetails().get("noOfChildren"));
		visitorPage.getSubmitBtn().click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

}
