package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	WebDriver driver;
	@FindBy(name = "username")
	private WebElement userNameTf;
	
	@FindBy(name = "password")
	private WebElement passWordTf;
	
	@FindBy(id = "form_submit")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//h4[text()='Admin ']")
	private WebElement adminBtn;
	
	@FindBy(linkText = "Log Out")
	private WebElement logOutBtn;
	
	
	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getUserNameTf() {
		return userNameTf;
	}


	public WebElement getPassWordTf() {
		return passWordTf;
	}


	
	
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}


	public WebElement getAdminBtn() {
		return adminBtn;
	}


	public WebElement getLogOutBtn() {
		return logOutBtn;
	}


	public void loginDetails(String uName,String pWord) {
		userNameTf.sendKeys(uName);
		passWordTf.sendKeys(pWord);
		
		
	}
}
