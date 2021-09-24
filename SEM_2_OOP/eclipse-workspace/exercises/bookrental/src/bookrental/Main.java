package bookrental;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList <Book> books = new ArrayList<Book>();
	TotalPrice totals = new TotalPrice(0);
	
	public Main() {
		// TODO Auto-generated method stub
		int menu = 0;
		
		do {
			menu = getMenu();
			switch (menu) {
			case 1:
				addBook();
				break;
			case 2:
				view();
				break;
			default:
				break;
			}
		} while (menu != 3);
		
		for(int i = 0; i < books.size(); i++) {
			books.remove(i);
		}
		totals = null;
		System.out.println("All of the books have been removed. Thank you for using this application.. ^^");

	}
	public void addBook() {
		if (books.size() == 10) {
			System.out.println("Can't add more books again!!!");
		}
		else {
			String title = "";
			do {
				System.out.print("Input the book title[5..20]: ");
				title = scan.nextLine();
			} while (title.length() < 5 || title.length() > 20);
			
			int price = 0;
			do {
				try {
					System.out.print("Input the book price[5000..10000]:Rp. ");
					price = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					// TODO: handle exception
					scan.nextLine();
				}
			} while(price < 5000 || price > 10000);
			
			int quantity = 0;
			do {
				try {
					System.out.print("Input the quantity of the books[1..20]: ");
					quantity = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					// TODO: handle exception
					scan.nextLine();
				}
			} while (quantity < 1 || quantity > 20);
			
			Book newBook = new Book(title, price, quantity);
			books.add(newBook);
			totals.incrementTotal(price * quantity);
		}
	}
	
	public void view() {
		System.out.println("List Ordered Book");
		System.out.println("=================");
		if (books.isEmpty()) {
			System.out.println("There's no ordered book here...");
		}
		else {
			System.out.println("");
			System.out.println("=========================================================");
			System.out.printf("|%-4s |%-20s |%-4s |%-9s |%-9s |\n", "No.", "Title", "Qty", "Price", "Subtotal");
			System.out.println("=========================================================");
			for (int i = 0; i < books.size(); i++) {
				System.out.printf("|%-4d |%-20s |%-4d |%-9d |%-9d |\n", i+1, books.get(i).getTitle(), books.get(i).getQuantity(),books.get(i).getPrice(), (books.get(i).getPrice()) * books.get(i).getQuantity());
			}
			System.out.println("=========================================================");
		}
		System.out.println("");
		System.out.println("");
		System.out.print("Total Price: Rp. ");
		System.out.println(totals.getTotal());
	}
	
	public int getMenu() {
		System.out.printf("\n\n\n\n\n\n\n\n");
		System.out.println("Welcome to Nanny's Bookrental\n");
		System.out.println("=============================");
		System.out.println("1. Rent a book");
		System.out.println("2. View all rent books");
		System.out.println("3. Exit and delete all rent books");
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		do {
			try {
				System.out.print("Choice : ");
				menu = scan.nextInt();
				scan.nextLine();
;			} catch (Exception e) {
				// TODO: handle exception
				scan.nextLine();
			}
		} while (menu < 1 || menu > 3);
		
		return menu;
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
