package checkChar1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO create a program to determine whether a character is alphanumeric
		// TODO create a program to determine whether a character is in lowercase or uppercase
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Check Character Program");
		System.out.println("1. Check alphanumeric");
		System.out.println("2. Check lower/uppercase");
		System.out.print(">>");
		int menu = 0;
		try {
			menu = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}
		
		
		switch (menu) {
		case 1:
			alphanumeric();
			break;
		case 2:
			lowerUpper();

		default:
			break;
		}
	}
	
	public static void alphanumeric() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Input Character: ");
		char c = scan.next().charAt(0);
		
		if (Character.isDigit(c) || Character.isLetter(c)) {
			System.out.println("Character is Alphanumeric");
		}
		else {
			System.out.println("Character is NOT Alphanumeric");
		}
	}
	
	public static void lowerUpper() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Input Character: ");
		char c = scan.next().charAt(0);
		
		char tmp = Character.toLowerCase(c);
		
		if (c == tmp) {
			System.out.println("Character is lowercase");
		}
		else {
			System.out.println("Character is uppercase");
		}
	}

}
