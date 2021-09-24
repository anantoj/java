package exercise3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <String> name = new ArrayList();
		ArrayList <String> pass = new ArrayList();
		ArrayList <String> phone = new ArrayList();
		
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		do {
			choice = menu();
			switch (choice) {
			case 1:

				System.out.print("Name: ");
				String inputName = scan.nextLine();
				System.out.print("Pass: ");
				String inputPass = scan.nextLine();
				System.out.print("Phone: ");
				String inputPhone = scan.nextLine();
				
				if (name.contains(inputName)) {
					System.out.println("Name already exist");
					int index = name.indexOf(inputName);
					pass.set(index, inputPass);
					phone.set(index, inputPhone);
					System.out.println("Data has been updated");
				}
				else {
					name.add(inputName);
					pass.add(inputPass);
					phone.add(inputPhone);
					System.out.println("New data has been added");
				}
		
				
				break;
			case 2:
				System.out.printf("%-10s %-10s %-10s %-10s\n", "No", "Name", "Pass", "Phone");
				if (name.isEmpty()) {
					System.out.println("No Data Exists!");
				}
				else {
					for (int i = 0; i < name.size(); i++) {
						System.out.printf("%d %10s %10s %10s\n", i+1, name.get(i), pass.get(i), phone.get(i));
					}
				}
				
				System.out.println("Press Enter to continue");
				scan.nextLine();
			
				break;
			case 3:
				System.out.printf("%-10s %-10s %-10s %-10s\n", "No", "Name", "Pass", "Phone");
				if (name.isEmpty()) {
					System.out.println("No Data Exists!");
				}
				else {
					for (int i = 0; i < name.size(); i++) {
						System.out.printf("%d %10s %10s %10s\n", i+1, name.get(i), pass.get(i), phone.get(i));
					}
				}
				System.out.print("Inout data number to be deleted: ");
				int index = scan.nextInt();
				name.remove(index-1);
				pass.remove(index-1);
				phone.remove(index-1);
				System.out.println("Data has been removed");
				System.out.println("Press Enter to continue");
				scan.nextLine();
				break;
			default:
				break;
			}
		} while (choice != 4);
	}
	
	public static int menu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("1. Input Data");
		System.out.println("2. Show Data");
		System.out.println("3. Delete Data");
		System.out.println("4. Exit");
		System.out.print("Your choice: ");
		int choice = 0;
		try {
			choice = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return choice;
	}

}

