import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);
	ArrayList<Tea> teaList = new ArrayList<>();
	ArrayList<Donut> donutList = new ArrayList<>();
	
	public Main() {
		// TODO Auto-generated constructor stub
		
		int menu = 0;
		do{
			cls();
			System.out.println("+------------------+");
			System.out.println("      ShaTime");
			System.out.println("+------------------+");
			System.out.println("1. Insert Product");
			System.out.println("2. View Products");
			System.out.println("3. Sell Products");
			System.out.println("4. Exit");
			System.out.print(">> ");
			
			menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu){
			case 1: insertMenu(); break;
			case 2: viewMenu();	break;
			case 3: sellMenu(); break;
			case 4: 
				cls();
				System.out.println("Have a nice day :)");
				break;
			}
		} while (menu != 4);
	}

	/*============================MENU============================*/
	private void sellMenu() {
		int choose = 0;
		do{
			cls();
			System.out.println("Choose Menu");
			System.out.println("1. Tea Menu");
			System.out.println("2. Donut Menu");
			System.out.println("0. Exit");
			System.out.print(">> ");
			
			choose = scan.nextInt();
			scan.nextLine();
		}while(choose < 0 || choose > 2);
		
		if(choose == 0) return;
		
		cls();
		if(!view(choose)){
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		
		System.out.println("");
		int id, qty;
		
		if(choose == 1){
			do{
				System.out.print("Input Id to sell [1.."+teaList.size()+"] : ");
				id = scan.nextInt();
				scan.nextLine();
			} while(id < 1 || id > teaList.size());
			
			do{
				System.out.print("Input quantity [>= 1] : ");
				qty = scan.nextInt();
				scan.nextLine();
			} while( qty < 1);
			
			System.out.println("Total Price : "+(qty*(teaList.remove(id-1).getPrice())));
			
		} else{
			do{
				System.out.print("Input Id to sell [1.."+donutList.size()+"] : ");
				id = scan.nextInt();
				scan.nextLine();
			} while(id < 1 || id > donutList.size());
			
			do{
				System.out.print("Input quantity [>= 1] : ");
				qty = scan.nextInt();
				scan.nextLine();
			} while( qty < 1);
			System.out.println("Total Price : "+(qty*(teaList.remove(id-1).getPrice())));
		}
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	private void insertMenu() {
		int choose = 0;
		do{
			cls();
			System.out.println("Choose item");
			System.out.println("1. Tea");
			System.out.println("2. Milk Tea");
			System.out.println("3. Donut");
			System.out.println("0. Exit");
			System.out.print(">> ");
			
			choose = scan.nextInt();
			scan.nextLine();
		}while(choose < 0 || choose > 3);
		
		if(choose == 0) return;
		cls();
		String name;
		int price;
		
		if(choose == 1){
			do{
				System.out.print("Input name [must endswith 'Tea'] : ");
				name = scan.nextLine();
			} while(!name.endsWith("Tea"));
			
			do{
				System.out.print("Input price [18000..50000] : ");
				price = scan.nextInt();
				scan.nextLine();
			} while(price < 18000 || price > 50000);
			
			teaList.add(new Tea(name, price));
		}
		
		else if(choose == 2){
			String topping;
			
			do{
				System.out.print("Input name [must endswith 'Tea'] : ");
				name = scan.nextLine();
			} while(!name.endsWith("Tea"));

			do{
				System.out.print("Input topping [Boba|Grass Jelly|Red Bean] : ");
				topping = scan.nextLine();
			} while(!topping.equals("Boba") && !topping.equals("Grass Jelly") && !topping.equals("Red Bean"));			
			do{
				System.out.print("Input price [25000..50000] : ");
				price = scan.nextInt();
				scan.nextLine();
			} while(price < 25000 || price > 50000);
			
			//Object boleh child class
			//Tapi method child/atribut child class tidak bisa diakses
			teaList.add(new MilkTea(name, price, topping));
		}
		
		else if(choose == 3){
			String filling;
			
			do{
				System.out.print("Input name [must endswith 'Donut'] : ");
				name = scan.nextLine();
			} while(!name.endsWith("Donut"));

			do{
				System.out.print("Input filling [3 - 12 chars] : ");
				filling = scan.nextLine();
			} while(filling.length() < 3 || filling.length() > 12);	
		
			do{
				System.out.print("Input price [30000..50000] : ");
				price = scan.nextInt();
				scan.nextLine();
			} while(price < 30000 || price > 50000);
			
			donutList.add(new Donut(name, filling, price));
		}
		
		System.out.println("Product successfully inserted!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}

	private void viewMenu() {
		int choose = 0;
		do{
			cls();
			System.out.println("Choose Menu");
			System.out.println("1. Tea Menu");
			System.out.println("2. Donut Menu");
			System.out.println("0. Exit");
			System.out.print(">> ");
			
			choose = scan.nextInt();
			scan.nextLine();
		}while(choose < 0 || choose > 2);
		
		
		if(choose == 0) return;
		
		cls();
		view(choose);
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}

	private boolean view(int choose){
		int index = 0;
		if(choose == 1){
			if(teaList.isEmpty()){
				System.out.println("There is no tea or milk tea");
				return false;
			}
			for (Tea tea : teaList) {
				index++;
				System.out.println("Id      : "+index);
				System.out.println("Name    : "+tea.getName());
				System.out.println("Price   : "+tea.getPrice());
				System.out.println("");
			}
		}
		else{
			if(donutList.isEmpty()){
				System.out.println("There is no donut");
				return false;
			}
			for (Donut donut : donutList) {
				index++;
				System.out.println("Id      : "+index);
				System.out.println("Name    : "+donut.getName());
				System.out.println("Filling : "+donut.getFilling());
				System.out.println("Price   : "+donut.getPrice());
				System.out.println("");
			}
		}
		return true;
	}
	/*============================================================*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	private void cls(){
		for (int i = 0; i < 25; i++) {
			System.out.println("");
		}
	}
}
