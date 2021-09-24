package bluejackVet;

import java.util.ArrayList;
import java.util.Scanner;

class Pet{
	private int health;
	private String name;
	private String type;
	
	public int getHealth(){
		return health;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setHealth(int h){
		health = h;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setType(String t) {
		type = t;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("BJ VET");
		System.out.println("");
		ArrayList<Pet> pets = new ArrayList<Pet>();
		
		int menu = 0;
		do {
			menu = getMenu();
			switch (menu) {
			case 1:
				Pet newPet = new Pet();
				
				int health = 0;
				
				do {
					try {
						System.out.print("Input pet health[1 - 90]: ");
						health = scan.nextInt();
						scan.nextLine();
					} catch (Exception e) {
						// TODO: handle exception
						scan.next(); // DISCARD BAD INPUT
					}
				}while (health < 1 || health > 90);
					
				newPet.setHealth(health);
				
				System.out.print("Input pet name [5 - 15 characters]: ");
				String name = scan.nextLine();
				while (name.length() < 5 || name.length() > 15) {
					System.out.print("Input pet name [5 - 15 characters]: ");
					name = scan.nextLine();
				}
				newPet.setName(name);
				
				System.out.print("Input pet type [kit | puppy | kitten]: ");
				String type = scan.nextLine();
				while (!type.equals("kit") && !type.equals("puppy") && !type.equals("kitten")){
					System.out.print("Input pet type [kit | puppy | kitten]: ");
					type = scan.nextLine();
				} 
				newPet.setType(type);
				
				pets.add(newPet);
				System.out.println("Pet successfully added to the list...");
				break;

			case 2:
				System.out.println("+===================================================================+");
				System.out.printf("+ %-4s| %-20s | %-10s | %-10s | %-10s +\n", "No", "Name", "Type", "Sound", "Health");
				System.out.println("+===================================================================+");
				if (pets.isEmpty()) {
					System.out.printf("+ %-65s +\n", "Empty-");
				}
				else {
					for (int i = 0; i < pets.size(); i++) {
						Pet tmp = new Pet();
						tmp = pets.get(i);
						
						String sound = "";
						
						if ((tmp.getType()).equals("kit")) {
							sound = "clucking";
						}
						else if((tmp.getType()).equals("puppy")){
							sound = " bark bark";
						}
						else if ((tmp.getType()).equals("kitten")) {
							sound = "meow meow";
						}
						
						System.out.printf("+ %-4s| %-20s | %-10s | %-10s | %-10s +\n", i+1, tmp.getName(), tmp.getType(), sound, tmp.getHealth());
					}
				}
				System.out.println("+===================================================================+");
				break;
				
			case 3:
				if (!pets.isEmpty()) {
					int num  = 0;
					System.out.println("+===================================================================+");
					System.out.printf("+ %-4s| %-20s | %-10s | %-10s | %-10s +\n", "No", "Name", "Type", "Sound", "Health");
					System.out.println("+===================================================================+");
					for (int i = 0; i < pets.size(); i++) {
						Pet tmp = new Pet();
						tmp = pets.get(i);
							
						String sound = "";
							
						if ((tmp.getType()).equals("kit")) {
							sound = "clucking";
						}
						else if((tmp.getType()).equals("puppy")){
							sound = " bark bark";
						}
						else if ((tmp.getType()).equals("kitten")) {
							sound = "meow meow";
						}
						
						System.out.printf("+ %-4s| %-20s | %-10s | %-10s | %-10s +\n", i+1, tmp.getName(), tmp.getType(), sound, tmp.getHealth());
					}
					System.out.println("+===================================================================+");
					do {
						try {
							System.out.printf("choose pet number to update [1 - %d]: ", pets.size());
							num = scan .nextInt();
							scan.nextLine();
						} catch (Exception e) {
							// TODO: handle exception
							scan.next();
						}
					} while ( num < 1 || num > pets.size());
					
					Pet tmp = new Pet();
					tmp = pets.get(num-1);
					
					int newHealth = 0;
					
					do {
						try {
							System.out.print("Update pet health[1 - 90]: ");
							newHealth = scan.nextInt();
							scan.nextLine();
						} catch (Exception e) {
							// TODO: handle exception
							scan.next();
						}
					} while ( num < 1 || num > pets.size());
					
					if (newHealth < 20) {
						tmp.setHealth(25);
					}
					else {
						int oldHealth = tmp.getHealth();
						int updateHealth = (oldHealth + newHealth) / 2;
						tmp.setHealth(updateHealth);
					}
					
					System.out.println("Pet health updated..");
				}
				break;
				
			case 4:
				if (!pets.isEmpty()) {
					int num  = 0;
					System.out.println("+===================================================================+");
					System.out.printf("+ %-4s| %-20s | %-10s | %-10s | %-10s +\n", "No", "Name", "Type", "Sound", "Health");
					System.out.println("+===================================================================+");
					for (int i = 0; i < pets.size(); i++) {
						Pet tmp = new Pet();
						tmp = pets.get(i);
							
						String sound = "";
							
						if ((tmp.getType()).equals("kit")) {
							sound = "clucking";
						}
						else if((tmp.getType()).equals("puppy")){
							sound = " bark bark";
						}
						else if ((tmp.getType()).equals("kitten")) {
							sound = "meow meow";
						}
						
						System.out.printf("+ %-4s| %-20s | %-10s | %-10s | %-10s +\n", i+1, tmp.getName(), tmp.getType(), sound, tmp.getHealth());
					}
					System.out.println("+===================================================================+");
					do {
						try {
							System.out.printf("choose pet number to update [1 - %d]: ", pets.size());
							num = scan .nextInt();
							scan.nextLine();
						} catch (Exception e) {
							// TODO: handle exception
							scan.next();
						}
					} while ( num < 1 || num > pets.size());	
					
					pets.remove(num-1);
				}
				System.out.println("Pets treated!!");
				break;
			default:
				break;
			}
			if (menu != 5)
				System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n");
			else
				System.out.println("Thanks for using BJ-Vet Program");
		}while(menu != 5);
	}
	
	public static int getMenu() {
		System.out.println("+=====================+");
		System.out.printf("+%-21s+\n", "Menu");
		System.out.println("+=====================+");
		System.out.printf("+%-21s+\n", "1. Add Sick Pet");
		System.out.printf("+%-21s+\n", "2. View Sick List");
		System.out.printf("+%-21s+\n", "3. Update Pet Health");
		System.out.printf("+%-21s+\n", "4. Treat Pet");
		System.out.printf("+%-21s+\n", "5. Exit Program");
		System.out.println("+=====================+");
		System.out.print("Choice >> ");
		Scanner scan = new Scanner(System.in);
		int menu = scan.nextInt();
		scan.nextLine();
		return menu;
	}

}
