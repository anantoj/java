package car_showroom;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public Main(){
		int menu = 0;
		Jeep one = new Jeep();
		Sedan three = new Sedan();
		SUV two = new SUV();
		System.out.println(one.getCapacity() + " " + one.getSpeed());
		System.out.println(two.getCapacity() + " " + two.getSpeed());
		System.out.println(three.getCapacity() + " " + three.getSpeed());
		do {
			menu = getMenu();
			switch (menu) {
				case 1:
					
					break;
				case 2:
					
					break;
				default:
					break;
			}
		} while (menu != 3);
	}

	public int getMenu(){
		System.out.println("SHOWROOM");
		System.out.println("==============");
		System.out.println("1. Buy");
		System.out.println("2. Show");
		System.out.println("3. Exit");
		int menu = 0;
		do{
			try {
				System.out.print("Input: ");
				menu = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		} while (menu < 1 || menu > 3);
		return menu;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
