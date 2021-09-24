package meeting1;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);
		
			System.out.print("Hello");
			System.out.printf("%s %d\n", "Hai", 5);
			System.out.println("Hai");
			
			String name = "";
			int age;
		
			do {
				System.out.print("Input Name[5-25 in length]: ");
				name = scan.nextLine();
			}while(name.length()> 25 || name.length() < 5);
			
			System.out.print("Input Age: ");
			age = scan.nextInt();
			scan.nextLine(); // this can act as a getchar()	
			
			System.out.println("Name " + name);
			System.out.println("Age: " + age);
			
			String food = "";
			
			do {
				System.out.print("Choose Food: [Rice/Burger/Fries]: ");
				food = scan.nextLine();
				
			}while(!(food.equals("Rice")|| food.equals("Burger")|| food.equals("Fries")));
			
			
			for (int i = 0; i < 5; i++) {
				System.out.print( 1 + "" + i + " ");
			}
			
			if (age< 20){
				System.out.println("You are underaged");
			}
			else{
				System.out.println("Hello " + name);
				System.out.println("1. Main Menu");
				System.out.println("2. Exit");
				
				System.out.print(">> ");
				
				int choose;
				choose = scan.nextInt();
				int weight;
				int height;
				
				switch (choose) {
				case 1:
					System.out.print("Input Height: ");
					height = scan.nextInt();
					scan.nextLine();
					
					System.out.print("Input weight: ");
					weight = scan.nextInt();
					scan.nextLine();
					
					double idealWeight = (height - 100) + (0.1 * (height - 100));
				
					System.out.println("Your Weight: " + weight);
					System.out.println("Ideal Weight: " + idealWeight);
					
					break;

				case 2:
					// splash screen LOL
					System.out.println("Always try new things, overcome all obstacles");
					System.exit(0);
					
					break;
					
				default:
					break;
				}
			}	
	}
}
