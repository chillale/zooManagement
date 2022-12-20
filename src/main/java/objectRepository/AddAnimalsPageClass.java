package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAnimalsPageClass {
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Animals Details']")
	private WebElement animalDetailsBtn;
//	
//	@FindBy(xpath = "//i[@class='ti-folder']")
//	private WebElement animalDetailsBtn;
	
	@FindBy(linkText = "Add Animals")
	private WebElement addAnimalsBtn;
	
	@FindBy(linkText = "Manage Animals")
	private WebElement manageAnimalsBtn;
	
	@FindBy(id = "aname")
	private WebElement animalNameTf;
	
	@FindBy(name = "image")
	private WebElement imagefile;
	
	@FindBy(name="cnum")
	private WebElement cageNumberTf;
	
	@FindBy(name = "fnum")
	private WebElement feedNumberTf;
	
	@FindBy(name = "breed")
	private WebElement breedNumber;
	
	@FindBy(name = "desc")
	private WebElement descriptionOfAnimal;
	
	@FindBy(linkText = "Home")
	private WebElement homeBtn;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	public AddAnimalsPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAnimalDetailsBtn() {
		return animalDetailsBtn;
	}

	public WebElement getAddAnimalsBtn() {
		return addAnimalsBtn;
	}

	public WebElement getManageAnimalsBtn() {
		return manageAnimalsBtn;
	}

	public WebElement getAnimalNameTf() {
		return animalNameTf;
	}

	public WebElement getImagefile() {
		return imagefile;
	}

	public WebElement getCageNumberTf() {
		return cageNumberTf;
	}

	public WebElement getFeedNumberTf() {
		return feedNumberTf;
	}

	public WebElement getBreedNumber() {
		return breedNumber;
	}

	public WebElement getDescriptionOfAnimal() {
		return descriptionOfAnimal;
	}
	

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	

}
