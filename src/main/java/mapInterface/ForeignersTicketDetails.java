package mapInterface;

import java.util.LinkedHashMap;

import com.github.javafaker.Faker;

public class ForeignersTicketDetails {
	public static  LinkedHashMap<String,String> foreignersDetails() {
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		Faker faker = new Faker();
		linkedHashMap.put("visitorName", faker.name().fullName());
		linkedHashMap.put("noOfAdult", faker.number().digit());
		linkedHashMap.put("noOfChildren", faker.number().digit());
		return linkedHashMap;
		
		
	}

}
