package shoe_shop;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList<Shoe> shoeList = new ArrayList<Shoe>();

	public Main(){
		int menu = 0;
		do{
			menu = getMenu();
			switch (menu) {
				case 1:
					view1();
					break;
				case 2:
					addShoe();
					break;
				case 3:
					deleteShoe();
					break;
				default:
					break;
			}
		}while (menu != 4);
		System.out.println("Thank you for using this application");
	}

	public void view1(){
		if (shoeList.isEmpty()){
			System.out.println("No shoes available..");
		}
		else{
			for (int i = 0; i < shoeList.size(); i++){
				System.out.printf("%d %s-%s\n", i+1, shoeList.get(i).getName(), shoeList.get(i).getCode());
				System.out.println("================");
				System.out.println("Category: " + shoeList.get(i).getCategory());
				System.out.println("Release date: " + shoeList.get(i).getReleaseDate());
				System.out.println("Price: " + shoeList.get(i).getPrice());
				System.out.println("");
			}
		}
		System.out.println("Press enter to continue;");
		scan.nextLine();
	}

	public void view2(){
		if (shoeList.isEmpty()){
			System.out.println("No shoes available..");
			System.out.println("Press enter to continue;");
			scan.nextLine();
		}
		else{
			for (int i = 0; i < shoeList.size(); i++){
				System.out.printf("%d. %s-%s\n", i+1, shoeList.get(i).getName(), shoeList.get(i).getCode());
				System.out.println("================");
				System.out.println("Category: " + shoeList.get(i).getCategory());
				System.out.println("Release date: " + shoeList.get(i).getReleaseDate());
				System.out.println("Price: " + shoeList.get(i).getPrice());
				System.out.println("");
			}
		}
	}

	public void deleteShoe(){
		view2();
		int index = 0;
		if (!shoeList.isEmpty()){
			do{
				System.out.printf("Choose shoe's number to delete[1..%d]: ", shoeList.size());
				index = scan.nextInt();
			} while (index < 1 || index > shoeList.size());
			shoeList.remove(index-1);
			System.out.println("Shoe removed!");
		}
	}

	public void addShoe(){
		String name = "", category = "", date = "";
		int price = 0;
		int day = 0, month = 0, year = 0;
		do{
			System.out.printf("Input shoe's name[name ends with shoe, example: \"Fire shoe\"]: ");
			name = scan.nextLine();
		}while (!name.contains("shoe"));

		do{
			System.out.print("Input shoe's category[Sneaker | Running | Boot] (case sensitive): ");
			category = scan.nextLine();
		}while (!category.equals("Sneaker") && !category.equals("Running") && !category.equals("Boot"));
		
		do{
			System.out.print("Input shoe's release date[dd-mm-yyyy]: ");
			date = scan.nextLine();
			String[] array = date.split("-");
			if (array.length == 3){
				day = Integer.parseInt(array[0]);
				month = Integer.parseInt(array[1]);
				year = Integer.parseInt(array[2]);
			}
			
		}while (date.length() != 10 || day < 1 || day > 30 || month < 1 || month > 12 || year < 2000 || year > 2020);
			
		do{
			try {
				System.out.print("Input shoe's price[more than or equals to 5000]: ");
				price = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		} while (price < 5000);

		
		Shoe newShoe = new Shoe(name, category, date, price);
		Random rand = new Random();
		int a = rand.nextInt(10);
		int b = rand.nextInt(10);
		int c = rand.nextInt(10);

		String code = "SH" + Integer.toString(a) + Integer.toString(b) + Integer.toString(c);

		newShoe.setCode(code);
		shoeList.add(newShoe);
		System.out.println("Shoe added!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}

	public int getMenu(){
		System.out.println("Shoe Shop");
		System.out.println("=========");
		System.out.println("1. View Shoes");
		System.out.println("2. Add Shoe");
		System.out.println("3. Delete Shoe");
		System.out.println("4. Exit");
		
		int menu = 0;
		do{
			try {
				System.out.print(">> ");
				menu = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			} 
		} while (menu < 0 || menu > 4);
		return menu;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Main();
	}
}
