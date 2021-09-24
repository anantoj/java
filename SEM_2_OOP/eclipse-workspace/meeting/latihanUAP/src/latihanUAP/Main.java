package latihanUAP;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.View;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Drink> drinks = new ArrayList<>();

	void add() {
		String name;
		String size;
		String type;

		do {
			System.out.print("Type [Coffee | Milk Tea] : ");
			type = scan.nextLine();
		} while (!type.equals("Coffee") && !type.equals("Milk Tea"));

		do {
			System.out.print("Name [5 - 15 chars] : ");
			name = scan.nextLine();
		} while (name.length() < 5 || name.length() > 15);

		do {
			System.out.print("Size [Small|Medium|Large] : ");
			size = scan.nextLine();
		} while (!size.equals("Small") && !size.equals("Medium") && !size.equals("Large"));

		if (type.equals("Coffee")) {
			int sugar;
			do {
				System.out.print("Sugar [0 - 5] : ");
				sugar = scan.nextInt();
				scan.nextLine();
			} while (sugar < 0 || sugar > 5);
			Coffee c = new Coffee(name, size, sugar);
			while(isUnique(c.getId()) == false) {
				c.generateId();
			}
			drinks.add(c);
		} 
		else {
			String topping;
			do {
				System.out.print("Topping [Boba|Grass Jelly] : ");
				topping = scan.nextLine();
			} while (!topping.equals("Boba") && !topping.equals("Grass Jelly"));
			MilkTea mt = new MilkTea(name, size, topping);
			while(isUnique(mt.getId()) == false){
				mt.generateId();
			}
			drinks.add(mt);
		}

		System.out.println("Success add a new drink");
		scan.nextLine();
	}

	void view() {
		if (drinks.isEmpty()) {
			System.out.println("There is no drink!");
			return;
		}

		System.out.printf("| %2s | %5s | %-15s | %-10s | %-5s | %-12s | %-10s |\n",
                "No", "Id", "Name", "Size", "Sugar", "Topping", "Price"
                );

		int index = 1;
		for (Drink drink : drinks) {
			System.out.printf("| %2d ", index++);
			drink.display();
		}
	}

	void sell() {
		if (drinks.isEmpty()) {
			System.out.println("There is no drink to sell");
			scan.nextLine();
			return;
		}
		view();

		int index;

		do {
			System.out.print("Index [0 for exit] : ");
			index = scan.nextInt();
			scan.nextLine();
		} while (index < 0 || index > drinks.size());

		String message = drinks.remove(index-1).getOrder();

		// Drink drink = drinks.get(index-1);
		// String message1 = drink.getOrder();
		// drinks.remove(drink);
		System.out.println(message);
	}

	public boolean isUnique(String id) {
		if (drinks.isEmpty()) return true;

		for (Drink drink : drinks) {
			if (drink.getId().equals(id)) return false;
		}

		return true;
	}

	public Main() {
		// TODO Auto-generated constructor stub
		int menu = 0;
		do {
			System.out.println("1. Add a Drink");
			System.out.println("2. View Drinks");
			System.out.println("3. Sell a drink");
			System.out.println("4. Exit");
			System.out.print(">> ");

			menu = scan.nextInt();
			scan.nextLine();

			switch (menu) {
				case 1:
					add();
					break;
				case 2:
					view();
					break;
				case 3:
					sell();
					break;
				default:
					break;
			}
		} while (menu != 4);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
