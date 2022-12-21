package addAnimals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import static genericUtility.FakerUtils.*;
import static mapInterface.HashMapCollections.*;
import genericUtility.BaseClassZoo;
import objectRepository.AddAnimalsPageClass;

public class AddSmallTigerTest extends BaseClassZoo{
	@Test
	public void addSmallTiger() throws Throwable  {
		AddAnimalsPageClass addAnimalsPageClass = new AddAnimalsPageClass(driver);
		addAnimalsPageClass.getAnimalDetailsBtn().click();
		addAnimalsPageClass.getAddAnimalsBtn().click();
		addAnimalsPageClass.getAnimalNameTf().sendKeys(animalName());
		addAnimalsPageClass.getImagefile().sendKeys(readFileFromHashMap().get("ParrotLove"));
		addAnimalsPageClass.getCageNumberTf().sendKeys(cageNumber());
		addAnimalsPageClass.getFeedNumberTf().sendKeys(feedNumber());
		addAnimalsPageClass.getBreedNumber().sendKeys(breed());
		addAnimalsPageClass.getDescriptionOfAnimal().sendKeys(description());
		addAnimalsPageClass.getSubmitBtn().click();
		Thread.sleep(2000);
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println(alertText);
		alert.accept();
		
	}

}
