package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NormalTicketPageTest {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Normal Ticket']")
	private WebElement normalTicketBtn;
	
	@FindBy(linkText = "Add Ticket")
	private WebElement addTicketBtn;
	
	public NormalTicketPageTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getNormalTicketBtn() {
		return normalTicketBtn;
	}

	public WebElement getAddTicketBtn() {
		return addTicketBtn;
	}
	
	

}
