package genericUtility;

import java.util.Scanner;

public class JavaProgram {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("Enter the working day or weekend");
		n=sc.nextInt();
		System.out.println("0.Monday");
		System.out.println("1.Tuesday");
		System.out.println("2.Wednesday");
		System.out.println("3.Thursday");
		System.out.println("4.Friday");
		System.out.println("5.Saturday");
		System.out.println("6.Sunday");
		switch (n) {
		case 0:System.out.println("Monday");
			
			break;
		case 1:System.out.println("Tuesday");
		break;
		case 2:System.out.println("Wednesday");
		break;
		case 3:System.out.println("Thursday");
		break;
		case 4:System.out.println("Friday");
		break;
		case 5:System.out.println("Saturday");
		break;
		case 6:System.out.println("Sunday");
		break;

		default:System.out.println("invalid source");
			break;
		}
	}

}
