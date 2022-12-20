package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTicketPageClass {
	WebDriver driver;
	
	@FindBy(name = "visitorname")
	private WebElement visitorNameTf;
	
	@FindBy(name = "noadult")
	private WebElement noOfAdultTf;
	
	@FindBy(name = "nochildren")
	private WebElement noOfChildrenTf;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	public AddTicketPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getVisitorNameTf() {
		return visitorNameTf;
	}

	public WebElement getNoOfAdultTf() {
		return noOfAdultTf;
	}

	public WebElement getNoOfChildrenTf() {
		return noOfChildrenTf;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	

}
