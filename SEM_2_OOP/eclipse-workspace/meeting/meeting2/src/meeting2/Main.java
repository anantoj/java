package meeting2;

import java.util.Random;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = 0;
			
		do {
			try {
				System.out.print("Input number: ");
				num = scan.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				scan.nextLine();
				System.out.println("error");
			} finally {
				// finally code will run after try and catch, despite the program having errors
				num = 1;
			}
			
			
		} while ( num != 1);
		
		System.out.print("\n\n\n\n\n\n\n\n\n");
		System.out.println("Menu:");
		
		String name;
		
		do {
			System.out.print("Name [5-20 chars]: ");
			name = scan.nextLine();
			// we do not need a scan.nextLine() to intercept the enter or \n
			// if we are scanning an integer then another integer then we need a scan.nextLine()
		} while (name.length() < 5 || name.length() > 20);
		
		String address;
		
		do {
			System.out.print("Address [ends with Street]: ");
			address = scan.nextLine();
		} while (address.endsWith("Street") == false);
		
		String email;
		
		do {
			System.out.print("Email [contains @, and ends with .com]: ");
			email = scan.nextLine();
		} while (email.endsWith(".com") == false || email.contains("@") == false);
		
		
		
		
		// RANDOM
		// 1. Math.random
		// return a value from 0.00 - 1.00 without including 1.0
		
		int codeNum = (int)(Math.random()* 1000);
		
		// 2. Class Random
		Random rand = new Random();
		// using nextInt(n) will generate a random number from 0 to n;
		char c1 = (char)(rand.nextInt(26) + 'A');
		char c2 = (char)(rand.nextInt(26) + 'A');
		
		String code1;
		String code2;
		// 1. String.format()
		code1 = String.format("%s%s%d", c1, c2, codeNum);
		// 2. concat using +
		code2 = Character.toString(c1) + Character.toString(c2) + Integer.toString(codeNum);
		// NOTE: we need to use toString() because we cannot concat a char or an integer 	
		System.out.println(code1);
		System.out.println(code2);
		
		int menu;
		
		do {
			System.out.println("Hi " + name + "Your NIM is " + code1);
			System.out.println("1. Start Lesson");
			System.out.println("2. Exit");
			System.out.print(">>");
			
			
			try {
				menu = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
				scan.nextLine();
				menu = 0;
				
			}
			
			if (menu == 1) {
				String subject;
				do {
					System.out.print("Subject [Math | Indonesia]:");
					subject = scan.nextLine();
				} while (subject.equals("Math") == false && subject.equals("Indonesia") == false);
				// equalsIgnoreCase -> not case sensitive
				// equals -> case sensitive
				
				
				if (subject.equals("Math")) {
					String size;
					do {
						System.out.print("Input[width x height]: ");
						size = scan.nextLine();
					} while (!size.contains("x"));
					
					try {
						String[] rectangle = size.split("x");
						// we create an array of String called rectangle
						// split method will return an array of the splitted string
						int width = Integer.parseInt(rectangle[0]); // this converts string to int data type
						int height = Integer.parseInt(rectangle[1]);
						int area = width * height;
						System.out.println("Area: " + area);
						
						// 
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Input error");
						// they may input a char instead of an integer
					}
				}
				else if (subject.equals("Indonesia")) {
					String sentence;
					System.out.print("Input Sentence: ");
					sentence = scan.nextLine();
					
					int index;
					do {
						System.out.print("Input Index: ");
						index = scan.nextInt();
						scan.nextLine();
					} while (index< 0 || index > sentence.length());
					
					// isDigit = check if it is a number
					// isLetter = check if it is a letter
					char letter = sentence.charAt(index);
					if (Character.isDigit(letter)) {
						System.out.println(letter + "is a digit");
					}
					else {
						System.out.println(letter + "is a letter");
					}
				}
			}
		
			
			
		} while (menu != 2);
	}

}

/* NOTES
 * ======
 * 
 * Typecasting
 * 	wrapper class <-> wrapper class (use method)
 * 	data type <-> class (use method)
 * 	data type <-> data type (normal typecasting)
 * 
 *	data type -> String (wrapperClass.toString)
 *	
 *	
 */
