package visitorDetails;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import static mapInterface.VisitorDetails.*;
import genericUtility.BaseClassZoo;
import objectRepository.VisitorPage;

public class Visitor1Test extends BaseClassZoo{
	@Test(groups = "smoke")
	public void visitor() {
		VisitorPage visitorPage = new VisitorPage(driver);
		visitorPage.getNormalTicketBtn().click();
		visitorPage.getAddTicketBtn().click();
		visitorPage.getVisitorName().sendKeys(readVisitorDetails().get("visitorName"));
		visitorPage.getNoOfAdult().sendKeys(readVisitorDetails().get("noOfAdult"));
		visitorPage.getNoOfChildren().sendKeys(readVisitorDetails().get("noOfChildren"));
		visitorPage.getSubmitBtn().click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		visitorPage.getHomeBtn().click();
	}

}
