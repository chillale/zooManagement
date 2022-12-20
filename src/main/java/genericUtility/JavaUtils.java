package genericUtility;

import java.util.Random;

public class JavaUtils {
	
       public static int generateRandomNumber() {
    	   Random random = new Random();
    	   int value=random.nextInt(100);
    	   return value;
       }
}
