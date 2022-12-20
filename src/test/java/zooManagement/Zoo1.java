package zooManagement;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.JavaUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Zoo1 {
	public static void main(String[] args) throws Throwable {
        WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Zoo_Management_System/admin/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverUtilityZoo webDriverUtilityZoo = new WebDriverUtilityZoo(driver);
		
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("admin");
		
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys("Test@123");
		
		WebElement loginButton = driver.findElement(By.id("form_submit"));
		loginButton.click();
		
		WebElement normalTicketDd = driver.findElement(By.xpath("//span[text()='Normal Ticket']"));
		normalTicketDd.click();
		
		WebElement addTicketBtn = driver.findElement(By.xpath("//a[text()='Add Ticket']"));
		addTicketBtn.click();
		
		WebElement visitorNameTf = driver.findElement(By.id("visitorname"));
		visitorNameTf.sendKeys("Narayana Rao"+JavaUtils.generateRandomNumber());
		
		WebElement noOfAdult = driver.findElement(By.id("noadult"));
		noOfAdult.sendKeys(""+JavaUtils.generateRandomNumber());
		
		WebElement noOfChildren = driver.findElement(By.id("nochildren"));
		noOfChildren.sendKeys(""+JavaUtils.generateRandomNumber());
		
		WebElement submitBtn = driver.findElement(By.name("submit"));
		submitBtn.click();
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		WebElement reportsBtn = driver.findElement(By.xpath("//span[text()='Reports']"));
		reportsBtn.click();
		
//		String parentWindow1=webDriverUtilityZoo.switchToParent();
//		webDriverUtilityZoo.allHandles(parentWindow1);
//		
		WebElement normalTicket = driver.findElement(By.xpath("//a[text()='Normal People Report']"));
		normalTicket.click();
		
		WebElement fromDateSelect = driver.findElement(By.id("fromdate"));
		fromDateSelect.sendKeys("22"+"11"+"2022");
		
		WebElement toDate = driver.findElement(By.id("todate"));
		toDate.sendKeys("22"+"11"+"2022"+Keys.TAB+""+Keys.ENTER);
		
		
//		WebElement submitBtn1 = driver.findElement(By.xpath("//button[text()='Submit']"));
//		submitBtn1.click();
//		Thread.sleep(2000);
		
//		WebElement homeButton = driver.findElement(By.linkText("Home"));
//		homeButton.click();
//		
//		WebElement adminButton = driver.findElement(By.xpath("//a[text()='Admin ']"));
//		adminButton.click();
//		
//		WebElement logOutButton = driver.findElement(By.linkText("Log Out"));
//		logOutButton.click();
		
		
		
		
		
//		String pHandle=driver.getWindowHandle();
//		Set<String> allHandles = driver.getWindowHandles();
//		for(String singleWindow:allHandles) {
//			System.out.println(singleWindow);
//			if(!pHandle.equals(singleWindow)) {
//				driver.switchTo().window(singleWindow);
//			}
//		}
		
		  List<WebElement> table = driver.findElements(By.xpath("//table[@class='table text-center']/tbody/tr"));
		  System.out.println(table.size());
		  
		 // int count=0;
		  for(int i=1;i<=table.size();i++) {
			  
			  for(int j=1;j<=4;j++) {
			  String text = driver.findElement(By.xpath("//table[@class='table text-center']/tbody["+i+"]/tr/td[3]")).getText();
			  if(text.equals("Anusuya Bai8")) {
				  //count++;
				  System.out.println(text+ " is found at "+i);
				  break;
			  }
			  }
			  
		  }
		  //System.out.println(count);
		  WebElement homeButton = driver.findElement(By.linkText("Home"));
		  homeButton.click();
		  
		  //driver.switchTo().window(parentWindow1);
		  
		 WebElement adminBtn = driver.findElement(By.xpath("//h4[text()='Admin ']"));
		 adminBtn.click();
		 
		 WebElement logOutBtn = driver.findElement(By.linkText("Log Out"));
		 logOutBtn.click();
		 
		 
		
	}

}
