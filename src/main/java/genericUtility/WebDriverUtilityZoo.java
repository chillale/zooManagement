package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilityZoo {
	WebDriver driver;
	public WebDriverUtilityZoo(WebDriver driver) {
		this.driver=driver;
	}
	/*
	 * This is to maximize the window
	 * @author
	 */
	public void maximize() {
		driver.manage().window().maximize();
	}
	/*
	 * This is to minimize the window
	 * @author sravan
	 */
	public void minimize() {
		driver.manage().window().minimize();
	}
	/*
	 * This is for select
	 * @author
	 */
	public void selectByIndex(WebElement ele, int index) {
		Select select=new Select(ele);
		select.selectByIndex(index);
	}
	/*
	 * This is for selectByvalue
	 * @author
	 */
	public void selectByValue(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);
	}
	/*
	 * This is for selectByvisibleText
	 * @author sravan
	 */
	public void selectByvisibleText(String value, WebElement ele) {
		Select select = new Select(ele);
		select.selectByVisibleText(value);
	}
	/*
	 * This is to handle the window
	 * @author sravan
	 */
	public String switchToParent() {
		String pHandle=driver.getWindowHandle();
		System.out.println(pHandle);
		return pHandle;
	}
	/**
	 * This method is used for allwindowHandles
	 * @author Anish
	 * @param pHandle 
	 * @param pHandle
	 */
	public void allHandles(String pHandle) {
		Set<String> allWinHandles = driver.getWindowHandles();
		System.out.println("All Window handles are");
		for(String aw:allWinHandles) {
			System.out.println(aw);  
			if(!pHandle.equals(aw)) {
				driver.switchTo().window(aw);
				break;
			}
			else {
				driver.switchTo().window(pHandle);
			}
			
		}
	}
	/*
	 * This is to implicitly wait
	 */
	public void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/*
	 * This is for mouse over
	 */
	public void adminImage(WebElement ele) {
		Actions actions=new Actions(driver);
		actions.moveToElement(ele).perform();
	}

}
