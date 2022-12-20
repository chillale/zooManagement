package zooManagementForeignDetails;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import static mapInterface.ForeignersTicketDetails.*;
import genericUtility.BaseClassZoo;
import objectRepository.ForeignersTicketClass;
import objectRepository.LoginPageClass;

public class ForeignerVisotor3Test extends BaseClassZoo{
	@Test(groups = {"regression"})
	public void foreigner1() throws Throwable {
		ForeignersTicketClass foreignersTicketClass = new ForeignersTicketClass(driver);
		foreignersTicketClass.getForeignersTicketBtn().click();
		foreignersTicketClass.getAddTicketBtn().click();
		foreignersTicketClass.getVisitorName().sendKeys(foreignersDetails().get("visitorName"));
		foreignersTicketClass.getNoOfAdult().sendKeys(foreignersDetails().get("noOfAdult"));
		foreignersTicketClass.getNoOfChildren().sendKeys(foreignersDetails().get("noOfChildren"));
		foreignersTicketClass.getSubmitBtn().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		foreignersTicketClass.getHomeBtn().click();
	    
	}

}
