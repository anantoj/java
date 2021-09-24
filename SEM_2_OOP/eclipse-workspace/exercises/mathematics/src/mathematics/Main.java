package mathematics;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);

	public Main() {
		// TODO Auto-generated constructor stub
		int menu = 0; 
		do {
			menu = getMenu();
			switch (menu) {
				case 1:
					printElements();
					break;
				case 2:
					calculateCuboidVolume();
					break;
				case 3:
					simpleCalculator();
					break;
				default:
					break;
			}
		} while (menu != 4);
	}

	public void simpleCalculator(){
		System.out.println("CALCULATOR");
		System.out.println("==========");

		Integer num1 = scanNumber("first");
		Integer num2 = scanNumber("second");
	
		Calculator c = new Calculator();

		System.out.println("Add result: " + c.add(num1, num2));
		System.out.println("Subtract result: " + c.subtract(num1, num2));
		System.out.println("Multiply result: " + c.multiply(num1, num2));
		System.out.println("Divide result: " + c.divide(num1, num2));

		System.out.println("");
		System.err.println("Press any key to continue...");
		scan.nextLine();
		
		return;
	}

	public void calculateCuboidVolume(){
		System.out.println("Calculate cuboid volume");
		System.out.println("=======================");
		String type = "";
		do {
			System.out.print("Input value type you want to use[Double | Integer](Case Insensitive): ");
			type = scan.nextLine();
		} while (!type.equalsIgnoreCase("Double") && !type.equalsIgnoreCase("Integer"));

		if (type.equalsIgnoreCase("Double")){
			Double zero = 0.0;
			Double width = scanDimensions(zero, Double.class, "width");
			Double length = scanDimensions(zero, Double.class,  "length");
			Double height = scanDimensions(zero, Double.class, "height");

			Cuboid c = new Cuboid<Double>(width, length, height);

			Double volume = c.getWidth().doubleValue() * c.getLength().doubleValue() * c.getHeight().doubleValue();
			printCuboid(c, volume);
		} 
		else if (type.equalsIgnoreCase("Integer")){
			Integer zero = 0;
			Integer width = scanDimensions(zero, Integer.class, "width");
			Integer length = scanDimensions(zero, Integer.class,  "length");
			Integer height = scanDimensions(zero, Integer.class, "height");

			Cuboid c = new Cuboid<Integer>(width, length, height);

			Integer volume = (int)c.getWidth() * c.getLength().intValue() * c.getHeight().intValue();
			printCuboid(c, volume);
		}
		System.out.println("Press any key to continue...");
		scan.nextLine();
	}

	public <T> void printCuboid(Cuboid c, T volume){
		System.out.println("");
		System.out.println("The volume of the cuboid with:");
		System.out.println("Width: " + c.getWidth());
		System.out.println("Length: " + c.getLength());
		System.out.println("Height: " + c.getHeight());
		System.out.println("Volume: " + volume);
		System.out.println("");
	}

	public <T extends Number> T scanDimensions(T zero, Class<T> c, String message){
		T num = zero;
		if (c == Double.class){
			do {
				try {
					System.out.print("Input " + message + "[ >0]: ");
					num = c.cast(scan.nextDouble());
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
			} while (num.doubleValue() <= 0.0);
		}
		else if (c == Integer.class){
			do {
				try {
					System.out.print("Input " + message + "[ >0]: ");
					num = c.cast(scan.nextInt());
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
			} while (num.intValue() <= 0);
		}
		return num;
	}

	public void printElements(){
		ArrayList arr = new ArrayList<>();
		System.out.println("PRINT MENU");
		System.out.println("==========");
		System.out.println("1. Print numbers");
		System.out.println("2. Print words");
		int choice = 0;
		do {
			try {
				System.out.print("Choice: ");
				choice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		} while (choice < 1 || choice > 2);

		if (choice == 1){
			Integer one = scanNumber("first");
			Integer two = scanNumber("second");
			Integer three = scanNumber("third");
			
			arr.add(one);
			arr.add(two);
			arr.add(three);
			System.out.print("Numbers inputted: ");
			printArray(arr);
			
			System.out.println("Press any key to continue...");
			scan.nextLine();
		}
		else{
			String one = scanWord("first");
			String two = scanWord("second");
			String three = scanWord("third");
			
			arr.add(one);
			arr.add(two);
			arr.add(three);
			System.out.print("Names inputted: ");
			printArray(arr);
			
			System.out.println("Press any key to continue...");
			scan.nextLine();
		}
	}

	public Integer scanNumber(String message){
		Integer num = 0;
		do {
			try {
				System.out.print("Input " + message + " number[>0]: ");
				num = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		} while (num <= 0);
		return num;
	}

	public String scanWord(String message){
		String word = "";
		do {
			System.out.print("Input " + message + " word[must be more than 1 character]: ");
			word = scan.nextLine();
		} while (word.length() <= 1);
		return word;
	}

	public <T> void printArray(ArrayList<T> arr){
		for (T e : arr) {
			System.out.print(e + " ");
		}
		System.out.println("");
		System.out.println("");
	}

	public int getMenu(){
		System.out.println("1. Print elements");
		System.out.println("2. Calculate cuboid volume");
		System.out.println("3. Simple calculator");
		System.out.println("4. Exit");
		
		int menu = 0;
		do {
			try {
				System.out.print("Choice: ");
				menu = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		} while (menu < 1 || menu > 4);
		return menu;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
