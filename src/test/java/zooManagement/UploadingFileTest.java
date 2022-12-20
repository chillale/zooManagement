package zooManagement;

import org.testng.annotations.Test;

import genericUtility.BaseClassZoo;
import objectRepository.AddAnimalsPageClass;

public class UploadingFileTest extends BaseClassZoo {
	@Test
	public void uploadingFile() {
		AddAnimalsPageClass addAnimalsPageClass = new AddAnimalsPageClass(driver);
		addAnimalsPageClass.getAnimalDetailsBtn().click();
		addAnimalsPageClass.getAddAnimalsBtn().click();
		addAnimalsPageClass.getAnimalNameTf().sendKeys();
	}

}
