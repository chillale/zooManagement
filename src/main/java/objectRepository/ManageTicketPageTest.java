package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageTicketPageTest {
	WebDriver driver;
	@FindBy(linkText = "Manage Ticket")
	private WebElement manageTicketBtn;
	
	@FindBy(linkText = "View")
	private WebElement viewBtn;
	
	@FindBy(linkText = "Delete")
	private WebElement deleteBtn;
	
	public ManageTicketPageTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getManageTicketBtn() {
		return manageTicketBtn;
	}

	public WebElement getViewBtn() {
		return viewBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	

}
