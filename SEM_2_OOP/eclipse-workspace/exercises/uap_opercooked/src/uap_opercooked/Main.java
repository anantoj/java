package uap_opercooked;

import java.util.Vector;
// import java.util.ListIterator;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main{
	int totalProfit = 0;
	Scanner scan = new Scanner(System.in);
	Vector<MenuItem> cooks = new Vector<MenuItem>();
	Vector<MenuItem> menuBook = new Vector<MenuItem>();
	Vector<MenuItem> orderHistory = new Vector<MenuItem>();

	Thread cookCheck = new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true){
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				int keep = -1;
				for (MenuItem c : cooks) {
					if (c instanceof Dessert){
						Dessert d = (Dessert)c;
						if (d.getCookingTime() == 0){
							totalProfit += d.getPrice();
							keep = cooks.indexOf(c);
							break;
						}
					}
					if (c instanceof Drink){
						Drink d = (Drink)c;
						if (d.getCookingTime() == 0){
							totalProfit += d.getPrice();
							keep = cooks.indexOf(c);
							break;
						}
					}
				}
				if (keep != -1) {
					orderHistory.add(cooks.get(keep));
					cooks.remove(keep);
				}
				
			}
		}
	});
	public Main() {
		
		cookCheck.start();
		// TODO Auto-generated constructor stub
		int menu = 0;
		do {
			menu = getMenu();
			switch (menu) {
				case 1:
					addMenu();
					break;
				case 2:
					viewCookingProcess();
					break;
				case 3:
					viewOrderHistory();
					break;
				case 4:
					order();
					break;
				default:
					break;
			}
		} while (menu != 5);
	}

	public void cls(){
		for (int i = 0; i < 30; i++){
			System.out.println("");
		}
	}

	public void order(){
		if (menuBook.isEmpty()){
			System.out.println("There is no Dessert or Drink on the list!");
			System.out.println("");
			System.out.println("Press Enter to continue");
			scan.nextLine();
			return;
		}
		int index = 0;
		cls();
		System.out.printf("| %-3s | %-20s | %-6s | %-10s | %-10s | %-10s | %-6s |\n", "No", "Name", "Price", "Topping", "Callories", "Flavor", "Size");
		System.out.println("=======================================================================================");
		for (Object object : menuBook) {
			if (object instanceof Dessert){
				Dessert d = (Dessert)menuBook.get(index);
				System.out.printf("| %-3d | %-20s | %-6d | %-10s | %-10.2f | %-10s | %-6s |\n", index+1, d.getName(), d.getPrice(), d.getTopping(), d.getCalories(), " -", " -");
			}
			else{
				Drink d = (Drink)menuBook.get(index);
				System.out.printf("| %-3d | %-20s | %-6d | %-10s | %-10s | %-10s | %-6s |\n", index+1, d.getName(), d.getPrice(), " -", " -", d.getFlavor(), d.getSize());
			}
			index++;
		}
		int choose = 0;
		do {
			try {
				System.out.printf("Choose a menu to order [1 - %d]: ", menuBook.size());
				choose = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		} while (choose < 1 || choose > menuBook.size());
		String timeString = getTime();
		if (menuBook.get(choose-1) instanceof Dessert) {
			Dessert tmp = (Dessert)menuBook.get(choose-1);
			Dessert d = new Dessert(tmp.getName(), tmp.getPrice(), tmp.getTopping(), tmp.getCalories());
			d.setTimeString(timeString);
			Thread t1 = new Thread(d);
			t1.start();
			cooks.add(d);
			
		}
		else {
			Drink tmp = (Drink)menuBook.get(choose-1);
			Drink d = new Drink(tmp.getName(), tmp.getPrice(), tmp.getFlavor(), tmp.getSize());
			d.setTimeString(timeString);
			Thread t2 = new Thread(d);
			t2.start();
			cooks.add(d);
		}
		System.out.println("");
		System.out.println("Succesfully add to order list!");
		System.out.println("");
		System.out.println("Press Enter to continue");
		scan.nextLine();
	}


	public void viewOrderHistory(){
		if (orderHistory.isEmpty()){
			System.out.println("There is no order history!");
			System.out.println("");
			System.out.println("Press Enter to continue");
			scan.nextLine();
			return;
		}
		cls();
		System.out.printf("| %-3s | %-20s | %-6s | %-10s | %-10s | %-10s | %-6s | %-25s |\n", "No", "Name", "Price", "Topping", "Callories", "Flavor", "Size", "Order Time");
		System.out.println("===================================================================================================================");
		for (int i = 0; i < orderHistory.size(); i++){
			if (orderHistory.get(i) instanceof Dessert){
				Dessert d = (Dessert)orderHistory.get(i);
				System.out.printf("| %-3d | %-20s | %-6d | %-10s | %-10.2f | %-10s | %-6s | %-25s |\n", i+1, d.getName(), d.getPrice(), d.getTopping(), d. getCalories(), "-", "-", d.getTimeString());
			}
			else{
				Drink d = (Drink)orderHistory.get(i);
				System.out.printf("| %-3d | %-20s | %-6d | %-10s | %-10s | %-10s | %-6s | %-25s |\n", i+1, d.getName(), d.getPrice(), "-", "-", d.getFlavor(), d.getSize(), d.getTimeString());
			}
		}
		System.out.println("");
		System.out.println("Press Enter to continue");
		scan.nextLine();

	}

	public void viewCookingProcess(){
		if (cooks.isEmpty()){
			System.out.println("There is no cooking process recently!");
			System.out.println("");
			System.out.println("Press Enter to continue");
			scan.nextLine();
			return;
		}

		String wait = "a";

		Thread t = new Thread(new Runnable(){
			private volatile boolean exit = false;
			@Override
			public void run() {
				while(!exit){
					if (cooks.isEmpty()){
						System.out.println("There is no cooking process recently!");
						System.out.println("");
						System.out.println("Press Enter to continue");
						break;
					}
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						//TODO: handle exception
					}
					int i = 0;
					cls();
					System.out.printf("| %-3s | %-10s | %-20s | %-6s | %-9s   |\n", "No", "Type", "Name", "Price", "Time Left");
					System.out.println("==================================================================");
					for (MenuItem c: cooks) {
						if (c instanceof Dessert){
							Dessert d = (Dessert)cooks.get(i);
							System.out.printf("| %-3d | %-10s | %-20s | $%-5d | %-9s s |\n", i+1, "Dessert", d.getName(), d.getPrice(), d.getCookingTime());
						}
						else{
							Drink d = (Drink)cooks.get(i);
							System.out.printf("| %-3d | %-10s | %-20s | $%-5d | %-9s s |\n", i+1, "Drink", d.getName(), d.getPrice(), d.getCookingTime());
						}
						i++;
					}
					System.out.println("");
					System.out.println("Press Enter to continue");
				}
			}
			public void stop(){
				exit = true;
			}
		});
		t.start();
		while (!wait.equals("")){
			wait = scan.nextLine();
		}
		t.stop();
		return;
	}

	public void addMenu(){
		
		System.out.println("What do you want to add?");
		System.out.println("1. Dessert");
		System.out.println("2. Drink");
		int choose = 0;
		do {
			try {
				System.out.print("Choose: ");
				choose = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		} while (choose < 1 || choose > 2);
		String name = "";
		do {
			System.out.print("Input the name [at least 5 characters]: ");
			name = scan.nextLine();
		} while (name.length() < 5);
		int price = scanInteger("Input the price [10 - 500]: ", 10, 500);
		if (choose == 1){
			String topping = "";
			do {
				System.out.print("Input the topping ['Caramel' | 'Honey' | 'Syrup'](Case Insensitive): ");
				topping = scan.nextLine();
			} while (!topping.equalsIgnoreCase("Caramel") && !topping.equalsIgnoreCase("Honey") && !topping.equalsIgnoreCase("Syrup"));
			double calories = 0.0;
			do {
				try {
					System.out.print("Insert calories [1.00 - 99.00]: ");
					calories = scan.nextDouble();
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
			} while (calories < 1.0 || calories > 99.0);
			
			Dessert d = new Dessert(name, price, topping, calories);
			menuBook.add(d);
			
		}
		else if (choose == 2){
			String flavor = "";
			do {
				System.out.print("Input the flavor ['Mint' | 'Mix Berry' | 'Cheese'](Case Insensitive): ");
				flavor = scan.nextLine();
			} while (!flavor.equals("Mint") && !flavor.equals("Mix Berry") && !flavor.equals("Cheese"));

			String size = "";
			do {
				System.out.print("Input the size [S | M | L](Case Sensitive): ");
				size = scan.nextLine();
			} while (!size.equals("S") && !size.equals("M") && !size.equals("L"));
			Drink d = new Drink(name, price, flavor, size);
			menuBook.add(d);
		}
		System.out.println("");
		System.out.println("Successfully added a new menu!");
	}

	public int getMenu(){
		cls();
		System.out.println("Welcome to Opercooked");
		System.out.println("Today profit: $ " + totalProfit); 
		System.out.println("============================");
		System.out.println("1. Add Desert or Beverage");
		System.out.println("2. View Cooking Process");
		System.out.println("3. View Order History");
		System.out.println("4. Order Dessert or Beverage");
		System.out.println("5. Exit");
		int menu = scanInteger(">> ", 1, 5);
		return menu;
	}

	public String getTime(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss a");  
		LocalDateTime now = LocalDateTime.now(); 
		String timeString = dtf.format(now);
		return timeString;
	}


	public int scanInteger(String message, int lower, int upper){
		int n = 0;
		do {
			try {
				System.out.print(message);
				n = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		} while (n < lower || n > upper);
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	


}
