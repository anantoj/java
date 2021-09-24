package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int operator = 0;
		while (true){
			// state 1
			double total = 0, number1 = 0;
			number1 = menu1(total, number1);
			operator = scan.nextInt();
			System.out.print("Input Number: ");
			double number2 = scan.nextDouble();
			int counter = 0;
			// state 2
			do {
				if (counter == 0) {
					counter++;
				}
				else{
					menu2(total);
					operator = scan.nextInt();
					number1 = total;
					if (operator != 6 && operator != 7) {
						System.out.print("Input Number: ");
						number2 = scan.nextDouble();
					}
					
				}
				total = calculation(operator, number1, number2, total);
			} while (operator != 6);
			
		}
	}
	
	public static double calculation(int operator, double number1, double number2, double total) {
		switch (operator) {
		case 7:
			System.exit(0);
			break;
		case 6:
			break;
		case 1:
			total = number1 + number2;
			break;
		case 2:
			total = number1 - number2;
			break;
		case 3:
			total = number1 * number2;
			break;
		case 4:
			total = number1 / number2;
			break;
		case 5:
			total = number1 % number2;
			break;
		default:
			break;
		}
		return total;
	}
	
	public static double menu1(double total, double number1) {
		Scanner scan = new Scanner(System.in);
		System.out.print("\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Calculator");
		System.out.println("===========");
		System.out.println("Total = " + total);
		System.out.print("Input Number: ");
		number1 = scan.nextDouble();
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Modulo");
		System.out.println("6. Clear Total");
		System.out.println("7. Exit");
		System.out.print("Operator [1...7]: ");
		return number1;
	}
	
	public static void menu2(double total) {
		System.out.print("\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Calculator");
		System.out.println("===========");
		System.out.println("Total = " + total);
		
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Modulo");
		System.out.println("6. Clear Total");
		System.out.println("7. Exit");
		System.out.print("Operator [1...7]: ");
	}
}