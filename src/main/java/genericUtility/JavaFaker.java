package genericUtility;

import java.util.Random;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.graphbuilder.math.func.RandFunction;

public class JavaFaker {
	static Faker faker =new Faker();
	public static String foreignerName() {
		String foreignerName = faker.name().firstName();
		return foreignerName;
		
	}
	public static String animalName() {
		return faker.dog().name();
	}
	public static void main(String[] args) {
		System.out.println(new JavaFaker().foreignerName());
	}
	public static int randomNumber() {
		Random random=new Random();
		int value=random.nextInt(100);
		return value;
	}
	public static int cageNumber() {
		return faker.number().randomDigit();
	}
	public static int feedNumber() {
		return faker.number().randomDigit();
	}
	public static String breed() {
		return faker.dog().breed();
	}
	public static String description() {
		return faker.dog().sound();
	}
	
}
