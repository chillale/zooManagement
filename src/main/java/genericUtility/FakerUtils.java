package genericUtility;

import com.github.javafaker.Faker;

public class FakerUtils {
	static Faker faker = new Faker();
	public static String foreignerName() {
		return faker.name().fullName();
	}
	public static String animalName() {
		return faker.dog().name();
	}
	public static String cageNumber() {
		return faker.number().digit();
	}
	public static String feedNumber() {
		return faker.number().digit();
	}
	public static String breed() {
		return faker.dog().breed();
	}
	public static String description() {
		return faker.dog().sound();
	}
	

}
