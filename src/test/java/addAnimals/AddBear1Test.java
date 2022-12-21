package addAnimals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import static genericUtility.FakerUtils.*;
import genericUtility.BaseClassZoo;
import objectRepository.AddAnimalsPageClass;
import static mapInterface.HashMapCollections.*;
public class AddBear1Test extends BaseClassZoo{
	@Test
	public void addBear() {
		AddAnimalsPageClass addAnimalsPageClass = new AddAnimalsPageClass(driver);
		addAnimalsPageClass.getAnimalDetailsBtn().click();
		addAnimalsPageClass.getAddAnimalsBtn().click();
		addAnimalsPageClass.getAnimalNameTf().sendKeys(animalName());
		addAnimalsPageClass.getImagefile().sendKeys(readFileFromHashMap().get("SmallFox"));
		addAnimalsPageClass.getCageNumberTf().sendKeys(""+cageNumber());
		addAnimalsPageClass.getFeedNumberTf().sendKeys(""+feedNumber());
		addAnimalsPageClass.getBreedNumber().sendKeys(breed());
		addAnimalsPageClass.getDescriptionOfAnimal().sendKeys(description());
		addAnimalsPageClass.getSubmitBtn().click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		addAnimalsPageClass.getHomeBtn().click();
		
	}
}
