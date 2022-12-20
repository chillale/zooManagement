package genericUtility;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPageClass;

public class BaseClassZoo {
	public WebDriver driver;
	public static WebDriver sdriver;
	PropertyFile propertyFile = new PropertyFile();
//	LoginPageClass loginPageTest;
	WebDriverUtilityZoo webDriverUtilityZoo ;


	@BeforeSuite(groups = {"smoke","regression","integration","system"})
	public void connectToDataBase() {
		System.out.println("===> connect to database ====>");
	}

	@AfterSuite(groups = {"smoke","regression","integration","system"})
	public void disconnectDataBase() {
		System.out.println(" ===> Disconnect to DataBase===>");
	}

	@BeforeClass(groups = {"smoke","regression","integration","system"})
	public void launchTheBrowser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sdriver = driver;
		driver.get(propertyFile.readDataFromPropertyFile("url"));
		webDriverUtilityZoo= new WebDriverUtilityZoo(driver);
		webDriverUtilityZoo.maximize();
		webDriverUtilityZoo.implicitlyWait();
		
		
	}

	@AfterClass(groups = {"smoke","regression","integration","system"})
	public void closeTheBrowser() {
		driver.close();
	}

	@BeforeMethod(groups = {"smoke","regression","integration","system"})
	public void loginIntoApplication() throws Throwable {
		LoginPageClass		loginPageTest= new LoginPageClass(driver);
		loginPageTest.loginDetails(propertyFile.readDataFromPropertyFile("username"), propertyFile.readDataFromPropertyFile("password"));
		loginPageTest.getSubmitBtn().click();
	}
	@AfterMethod(groups = {"smoke","regression","integration","system"})
	public void logoutIntoApplication() {
		LoginPageClass		loginPageTest= new LoginPageClass(driver);
		loginPageTest.getAdminBtn().click();
		loginPageTest.getLogOutBtn().click();
	}

	public static String takeScreenshot(String name) {

		TakesScreenshot takeScreenShot = (TakesScreenshot)BaseClassZoo.sdriver;
		File source = takeScreenShot.getScreenshotAs(OutputType.FILE);
		String path = "./ScreenShot/"+name+".PNG";
		File destination = new File(path);
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
