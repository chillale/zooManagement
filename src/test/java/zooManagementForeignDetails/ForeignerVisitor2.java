package zooManagementForeignDetails;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import static mapInterface.ForeignersTicketDetails.*;
import genericUtility.BaseClassZoo;
import objectRepository.ForeignersTicketClass;
import objectRepository.LoginPageClass;

public class ForeignerVisitor2 extends BaseClassZoo{
	@Test(groups = {"smoke"})
	public void foreignersVisitor() {
		ForeignersTicketClass foreignersTicketClass = new ForeignersTicketClass(driver);
		foreignersTicketClass.getForeignersTicketBtn().click();
		foreignersTicketClass.getAddTicketBtn().click();
		foreignersTicketClass.getVisitorName().sendKeys(foreignersDetails().get("visitorName"));
		foreignersTicketClass.getNoOfAdult().sendKeys(foreignersDetails().get("noOfAdult"));
		foreignersTicketClass.getNoOfChildren().sendKeys(foreignersDetails().get("noOfChildren"));
		foreignersTicketClass.getSubmitBtn().click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		foreignersTicketClass.getHomeBtn().click();
		
	}

}
