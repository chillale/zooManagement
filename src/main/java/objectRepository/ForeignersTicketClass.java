 package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForeignersTicketClass {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Foreigners Ticket']")
	private WebElement foreignersTicketBtn;
	
	@FindBy(linkText = "Add Ticket")
	private WebElement addTicketBtn;
	
	@FindBy(name = "visitorname")
	private WebElement visitorName;
	
	@FindBy(id = "noadult")
	private WebElement noOfAdult;
	
	@FindBy(id = "nochildren")
	private WebElement noOfChildren;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement homeBtn;
	
	
	public ForeignersTicketClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	public WebElement getForeignersTicketBtn() {
		return foreignersTicketBtn;
	}

	public WebElement getAddTicketBtn() {
		return addTicketBtn;
	}

	public WebElement getVisitorName() {
		return visitorName;
	}

	public WebElement getNoOfAdult() {
		return noOfAdult;
	}

	public WebElement getNoOfChildren() {
		return noOfChildren;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}
	
	

}
