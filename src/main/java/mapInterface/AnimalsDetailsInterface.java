package mapInterface;

import java.util.HashMap;
import static mapInterface.HashMapCollections.*;
import com.github.javafaker.Faker;
import static genericUtility.JavaUtils.*;
import static mapInterface.ForeignersTicketDetails.*;
public class AnimalsDetailsInterface {
	public void animalDetails(String aName) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		Faker faker = new Faker();
		
		String animalName = faker.animal().name();
		if(aName.equals(animalName)) {
		hashMap.put("animalName", animalName);
		}
		hashMap.put("imageFile", readFileFromHashMap().get("GermanShepherdPuppy"));
		hashMap.put("cageNumber","1"+generateRandomNumber());
		hashMap.put("feedNumber", "2"+generateRandomNumber());
		hashMap.put("breedName", faker.dog().breed());
		hashMap.put("descriptionOfAnimal", faker.dog().sound());
		
		
	}

}
