package gslc1;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	public static int getMenu(String active) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("\n\n\n\n\n");
		System.out.println("Binus Banking System");
		System.out.println("=====================");
		if (active.length() != 0) {
			System.out.println("Hello " + active);
		}
		System.out.println("1. Create User");
		System.out.println("2. Login");
		System.out.println("3. Logout");
		System.out.println("4. Delete User");
		System.out.println("5. Show User");
		System.out.println("6. Exit");
		System.out.print("Menu: ");
		
		int menu = scan.nextInt();
		scan.nextLine();
		return menu;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);
			Vector <String> username = new Vector<String>();
			Vector <String> password = new Vector<String>();
			String active = "";
			int menu = 0;
			do {
				menu = getMenu(active);
				switch (menu) {
				case 1:
					System.out.print("Username: ");
					username.add(scan.nextLine());
					System.out.print("Password: ");
					String pass1 = scan.nextLine();
					System.out.print("Confirm password: ");
					String pass2 = scan.nextLine();
					while (pass1.equals(pass2) == false) {
						System.out.println("Passwords do not match");
						System.out.print("Confirm password: ");
						pass2= scan.nextLine();
					}
					password.add(pass1);
					break;
				case 2:
					if (active.length() != 0) {
						System.out.println("Logout First");
					}
					else if (username.isEmpty()) {
						System.out.println("No user exists");
					}
					else {
						System.out.print("Username: ");
						String name = scan.nextLine();
						while (username.contains(name) == false) {
							System.out.print("Username: ");
							name = scan.nextLine();
						}
						int index = username.indexOf(name);
						System.out.print("Password: ");
						String pass = scan.nextLine();
						while (password.elementAt(index).equals(pass) == false) {
							System.out.print("Password: ");
							pass = scan.nextLine();
						}
						System.out.println("Active: " + username.elementAt(index));
						active = username.elementAt(index);
					}
					break;
				case 3:
					if (active.length() == 0) {
						System.out.println("No active user");
					}
					else {
						active = "";
					}
					break;
				case 4:
					if (username.isEmpty()) {
						System.out.println("No user exists");
					}
					else {
						System.out.print("Input username to be deleted: ");
						String name = scan.nextLine();
						while (username.contains(name) == false) {
							System.out.println("Username does not exist");
							System.out.print("Input username to be deleted: ");
							name = scan.nextLine();
						}
						int index = username.indexOf(name);
						username.remove(index);
						password.remove(index);
						System.out.println(name + "'s Account has been deleted");
						
					}
					break;
				case 5:
					if (username.isEmpty()) {
						System.out.println("List is empty");
					}
					else {
						System.out.println("List Users");
						System.out.println("===============");
						for (int i = 0; i < username.size(); i++) {
							System.out.println(username.elementAt(i));
						}
					}
					break;
				default:
					break;
				}
			} while (menu != 6);
	}

}

