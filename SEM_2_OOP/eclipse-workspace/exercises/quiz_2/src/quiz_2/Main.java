package quiz_2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class Main implements Runnable{

    Scanner scan = new Scanner(System.in);

    Random rand = new Random();

    Vector<Item> itemList = new Vector<>();
    Vector<Item> boughtList = new Vector<>();
    Vector<History> histList = new Vector<>();

    boolean print = false;
    boolean order = false;

    Thread start_cook = new Thread(new Runnable() {
        
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    if (order) {
                        view_cooking_list();
                    }
                    remove_item();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void remove_item() {
            if (boughtList.isEmpty()) {
                return;
            }
            for (int i = 0; i < boughtList.size(); i++) {
                if (boughtList.get(i).getTime() <= 0) {
                    String date = getTime();
                   
                    if (boughtList.get(i) instanceof Dessert) {
                        Dessert tmp = (Dessert) boughtList.get(i);
                        History histories = new History(tmp.getName(), tmp.getPrice(), tmp.getTopping(), Double.toString(tmp.getCalories()), "-", "-" , date);
                        histList.add(histories);
                    }
                    else if (boughtList.get(i) instanceof Drink) {
                        Drink tmp = (Drink) boughtList.get(i);
                        History histories = new History(tmp.getName(), tmp.getPrice(), "-", "-", tmp.getFlavor(), tmp.getSize(), date);
                        histList.add(histories);
                    }
        
                    boughtList.remove(i);    
                }
            }
        }
    });

    public int get_total_price() {
        int total_price = 0;

        for (History histories : histList) {
            total_price += histories.getPrice();
        }

        return total_price;
    }

    public String getTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);
        return time; 
    }

    public void printMenu() {
        cls();
        System.out.println("Welcome to Opercooked");
        System.out.printf("Total Profit: $ %d\n", get_total_price());
        System.out.println("===========================");
        System.out.println("1. Add Dessert or Beverage");
        System.out.println("2. View Cooking Process");
        System.out.println("3. View Order History");
        System.out.println("4. Order Dessert or Beverage");
        System.out.println("5. Exit");
        System.out.print(">> ");
    }

    public void addFood() {
        cls();
        int choice = 0;
        String name = "", topping = "", flavor = "", size = "";
        int price = 0;
        double calories = 0;
        int time = 0, extra_time = 0;

        do {
            System.out.println("what do you want to add");
            System.out.println("1. Dessert");
            System.out.println("2. Drink");
            System.out.print("Choose: ");

            try {
                choice = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
            }
            
        } while (choice == 1 && choice == 2);

        do {
            System.out.print("Input the name [at least 5 characters]: ");
            name = scan.nextLine();
        } while (name.length() < 5);

        do {
            System.out.print("Input the price [10 - 500]: $ ");
            try {
                price = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
            }
        } while (price < 10 || price > 500);

        if (choice == 1) {
            
            do {
                System.out.print("Input the topping ['Caramel' | 'Honey' | 'Syrup'](case sensitive): ");
                topping = scan.nextLine();
            } while (!topping.equals("Caramel") && !topping.equals("Honey") && !topping.equals("Syrup"));

            switch (topping) {
                case "Caramel":
                    extra_time = 10;
                    break;

                case "Honey":
                    extra_time = 15;
                    break;

                case "Syrup":
                    extra_time = 20;
                    break;
            
                default:
                    break;
            }

            do {
                System.out.print("Insert calories [1.00 - 99.00]: ");
                try {
                    calories = scan.nextDouble();
                    scan.nextLine();
                } catch (Exception e) {
                    scan.nextLine();
                }
            } while (calories < 1.00 || calories > 99.00);

                      //random(50 - 90)
            time = (rand.nextInt(41) + 50) + extra_time;
            
            Dessert dessert = new Dessert(name, price, time, topping, calories);

            itemList.add(dessert);
        }

        else if (choice == 2) {

            do {
                System.out.print("Input the flavor ['Mint' | 'Mix Berry' | 'Cheese'](case sensitive): ");
                flavor = scan.nextLine();
            } while (!flavor.equals("Mint") && !flavor.equals("Mix Berry") && !flavor.equals("Cheese"));

            switch (topping) {
                case "Mint":
                    extra_time = 10;
                    break;

                case "Mix Berry":
                    extra_time = 20;
                    break;

                case "Cheese":
                    extra_time = 30;
                    break;
            
                default:
                    break;
            }

            do {
                System.out.print("Input the size [S | M | L](case sensitive): ");
                size = scan.nextLine();
            } while (!size.equals("S") && !size.equals("M") && !size.equals("L"));

                      //random(10 - 50)
            time = (rand.nextInt(41) + 10) + extra_time;

            Drink drink = new Drink(name, price, time, flavor, size);

            itemList.add(drink);
        }

        System.out.print("\nSuccessfully added a new menu!");
        scan.nextLine();
    }

    public void view_cooking_list() {
        cls();
        if (boughtList.isEmpty()) {
            order = false;
            System.out.println("There is no cooking process recently\n");
            System.out.print("Press enter to continue");
        }
        else if (!boughtList.isEmpty()) {
            System.out.println("| No  | Type     | Name                 | Price  | Time Left |");
            System.out.println("--------------------------------------------------------------");
            int i = 1;
            for (Item food : boughtList) {
                if (food instanceof Dessert) {
                    System.out.printf("| %-3d | %-8s | %-20s |  $%-5d | %-7d s |\n", i, "Dessert", food.getName(), food.getPrice(), food.getTime());
                }
                else if (food instanceof Drink) {
                    System.out.printf("| %-3d | %-8s | %-20s | $%-5d | %-7d s |\n", i, "Drink", food.getName(), food.getPrice(), food.getTime());
                }
                i++;
            }

            System.out.print("\nPress Enter to Continue");
        }
    }

    public void history() {
        cls();
        if (histList.isEmpty()) {
            System.out.println("There is no order history!\n");
            System.out.print("Press enter to continue");
            scan.nextLine();
        }

        else {
            System.out.println("| No  | Name                 | Price  | Topping    | Callories  | Flavor     | Size  | Order Time              |");
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            int i = 1;
            for (History history : histList) {
                System.out.printf("| %-3d | %-20s | %-6d | %-10s | %-10s | %-10s | %-5s | %-23s |\n", i, history.getName(), history.getPrice(), history.getTopping(), history.getCalories(), history.getFlavor(), history.getSize(), history.getOrderTime());
                i++;
            }

            System.out.print("\nPress enter to continue");
            scan.nextLine();
        }
    }

    public void order() {
        cls();
        if (itemList.isEmpty()) {
            System.out.println("There is no Dessert or Drink on the list");
            System.out.print("\nPress enter to continue");
            scan.nextLine();
            return;
        }
        System.out.println("| No  | Name                 | Price  | Topping    | Callories  | Flavor     | Size  |");
        System.out.println("--------------------------------------------------------------------------------------");
        int i = 1;
        for (Item item : itemList) {
            if (item instanceof Dessert) {
                System.out.printf("| %-3d | %-20s | %-6d | %-10s | %-10.2f | %-10s | %-5s |\n", i, item.getName(), item.getPrice(), ((Dessert) item).getTopping(), ((Dessert) item).getCalories(),"-", "-");
                i++;
            }

            else {
                System.out.printf("| %-3d | %-20s | %-6d | %-10s | %-10s | %-10s | %-5s |\n", i, item.getName(), item.getPrice(), "-", "-", ((Drink) item).getFlavor(), ((Drink) item).getSize());
                i++;
            }
        }

        int order = 0;
        do {
            System.out.printf("Choose a menu to order [1 - %d]: ", itemList.size());
            try {
                order = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
            }
        } while (order < 1 || order > itemList.size());

        if (itemList.get(order - 1) instanceof Dessert) {

            Dessert tmp = (Dessert) itemList.get(order - 1);
            Dessert dessert = new Dessert(tmp.getName(), tmp.getPrice(), tmp.getTime(), tmp.getTopping(), tmp.getCalories());
            boughtList.add(dessert);

            Thread dessertThread = new Thread(dessert);
            dessertThread.start();
        }
        else {

            Drink tmp = (Drink) itemList.get(order - 1);
            Drink drink = new Drink(tmp.getName(), tmp.getPrice(), tmp.getTime(), tmp.getFlavor(), tmp.getSize());
            boughtList.add(drink);

            Thread drinkThread = new Thread(drink);
            drinkThread.start();
        }
        System.out.println("Succesfully add to order list!\n");
        System.out.print("Press enter to continue");
        scan.nextLine();
    }

    void cls(){
		for (int i = 0; i < 25; i++) {
			System.out.println("");
		}
	}

    public Main() {

        int menu = 0;
        print = true;
        String wait = "";

        start_cook.start();

        Thread update_status = new Thread(this);
        update_status.start();

        do {
            try {
                menu = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
            }
            print = false;
            cls();

            switch (menu) {
                case 1:
                    addFood();
                    break;
                
                case 2:
                    order = true;
                    wait = scan.nextLine();
                    order = false;
                    break;

                case 3:
                    history();
                    break;

                case 4:
                    order();
                    break;

                case 5:
                    itemList.clear();
                    histList.clear();
                    System.exit(0);
                    break;
                default:
                    break;
            }
            print = true;
        } while (menu != 5);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                if (print) {
                    printMenu();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}