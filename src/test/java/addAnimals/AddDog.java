package addAnimals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import static mapInterface.HashMapCollections.*;
import genericUtility.BaseClassZoo;
import objectRepository.AddAnimalsPageClass;
import objectRepository.LoginPageClass;

import static genericUtility.JavaFaker.*;
public class AddDog extends BaseClassZoo{
	@Test
	public void addingDog() throws Throwable {
		AddAnimalsPageClass addAnimalsPageClass = new AddAnimalsPageClass(driver);
		addAnimalsPageClass.getAnimalDetailsBtn().click();
		addAnimalsPageClass.getAddAnimalsBtn().click();
		addAnimalsPageClass.getAnimalNameTf().sendKeys(animalName());
		addAnimalsPageClass.getImagefile().sendKeys(readFileFromHashMap().get("GermanShepherdDog"));
		addAnimalsPageClass.getCageNumberTf().sendKeys(""+cageNumber());
		addAnimalsPageClass.getFeedNumberTf().sendKeys(""+feedNumber());
		addAnimalsPageClass.getBreedNumber().sendKeys(breed());
		addAnimalsPageClass.getDescriptionOfAnimal().sendKeys(description());
		addAnimalsPageClass.getSubmitBtn().click();
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert();
		alert.accept();
		addAnimalsPageClass.getHomeBtn().click();
		
	}
}
