package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTest {
	
	     WebDriver driver;
	
		@FindBy(linkText = "Home") 
		private WebElement homeBtn;
		
		@FindBy(linkText = "About")
		private WebElement aboutBtn;
		
		@FindBy(linkText = "Contact")
		private WebElement contactBtn;
		
		@FindBy(linkText = "Animals")
		private WebElement animalsBtn;
		
		@FindBy(linkText = "Admin")
		private WebElement adminBtn;
		
		public HomePageTest(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements( driver, this);
		}

		public WebElement getHomeBtn() {
			return homeBtn;
		}

		public WebElement getAboutBtn() {
			return aboutBtn;
		}

		public WebElement getContactBtn() {
			return contactBtn;
		}

		public WebElement getAnimalsBtn() {
			return animalsBtn;
		}

		public WebElement getAdminBtn() {
			return adminBtn;
		}
		
		
		
		
		
	}


