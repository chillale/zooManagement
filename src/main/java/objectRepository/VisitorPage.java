 package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VisitorPage {
	    WebDriver driver;
	    @FindBy(xpath = "//span[text()='Normal Ticket']")
	    private WebElement normalTicketBtn;
	    
	    @FindBy(linkText = "Add Ticket")
	    private WebElement addTicketBtn;
	    
		@FindBy(id = "visitorname")
		private WebElement visitorName;
		
		@FindBy(id = "noadult")
		private WebElement noOfAdult;
		
		@FindBy(id = "nochildren")
		private WebElement noOfChildren;
		
		@FindBy(name = "submit")
		private WebElement submitBtn;
		
		@FindBy(linkText = "Home")
		private WebElement homeBtn;
		
		
		
		public VisitorPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
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

		public WebElement getNormalTicketBtn() {
			return normalTicketBtn;
		}

		public WebElement getAddTicketBtn() {
			return addTicketBtn;
		}
		
		
		
		
	

}
