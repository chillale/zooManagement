package mapInterface;

import java.util.Hashtable;

import com.github.javafaker.Faker;

public class VisitorDetails {
	public static Hashtable<String,String> readVisitorDetails() {
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		Faker faker = new Faker();
		hashTable.put("visitorName", faker.name().fullName());
		hashTable.put("noOfAdult", faker.number().digit());
		hashTable.put("noOfChildren", faker.number().digit());
		return hashTable;
		
	}

}
