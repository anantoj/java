import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList arr = new ArrayList<MenuItem>();
	public Main() {
		// TODO Auto-generated constructor stub
		int menu = 0;

		do {
			menu = getMenu();
			switch (menu) {
				case 1:
					addMenu();
					break;
				
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				default:
					break;
			}
		} while (menu != 5);
	}

	public void addMenu(){
		System.out.println("What do you want to add?");
		System.out.println("1. Dessert");
		System.out.println("2. Drink");
		int choose = 0;
		do {
			try {
				System.out.println("Choose: ");
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
					calores = scan.nextDouble();
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
			} while (calories < 1.0 || calories > 99.0);
		}
		else if (choose == 2){
			String flavor = "";
			do {
				System.out.print("Input the flavor ['Mint' | 'Mix Berry' | 'Cheese'](Case Insensitive): ");
				flavor = scan.nextLine();
			} while (!flavor.equals("Mint") && !flavor.equals("Mix Berry") && !flavor.equals("Cheese"));

			char size = ' ';
			do {
				System.out.println("Input the size [S | M | L](Case Sensitive): ");
				size = scan.nextLine().charAt(0);
			} while (size != 'S' && size != 'M' && size != 'L');
		}

		System.out.println("");
		System.out.println("Successfully added a new menu!");
	}


	public int getMenu(){
		System.out.println("Welcome to Opercooked");
		System.out.println("Today profit: $"); // TODO: INSERT PROFIT HERE
		System.out.println("1. Add Desert or Beverage");
		System.out.println("2. View Cooking Process");
		System.out.println("3. View Order History");
		System.out.println("4. Order Dessert or Beverage");
		System.out.println("5. Exit");
		int menu = scanInteger(">> ", 1, 5);
		return menu;
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
