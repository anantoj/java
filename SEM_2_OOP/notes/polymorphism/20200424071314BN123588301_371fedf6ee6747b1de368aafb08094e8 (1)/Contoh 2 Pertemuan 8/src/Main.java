import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	//panduan membuat polymorphism
	//Sebelum melihat isi dari MainClass
	//Step 0. Buka kelas Sportcar

	//keyword "instanceof" : 
	//	instanceof adalah salah satu keyword pada Java, yang digunakan untuk membandingkan suatu objek, 
	//	apakah instansiasi dari suatu class atau tidak, 
	//	hasil dari perbandingan tersebut akan menghasilkan nilai boolean berupa nilai true atau false. 

	Scanner sc = new Scanner(System.in);
	ArrayList<Car> arr = new ArrayList<Car>();

	int menu;

	public void title() {
		System.out.println("        _______");
		System.out.println("       //  ||\\ \\");
		System.out.println(" _____//___||_\\ \\___");
		System.out.println(" )  _          _    \\");
		System.out.println(" |_/ \\________/ \\___|");
		System.out.println("___\\_/________\\_/______");
		System.out.println("+++++++++++++++++++++++++");
		System.out.println("     OLINE's CarShop     ");
		System.out.println("+++++++++++++++++++++++++");
	}
// Method Clear Screen
	public void cls() {
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}
	// Method Menu
	public void menu() {
		System.out.println("+++++++++++++++++++++++++");
		System.out.println("     OLINE's CarShop     ");
		System.out.println("+++++++++++++++++++++++++");
		System.out.println("1. Input New Car");
		System.out.println("2. Display All Cars");
		System.out.println("3. Car Sound Test");
		System.out.println("4. Sell All Car");
		System.out.println("5. Exit");
		System.out.print("Choose >>");
	}
//Method Untuk Menginput Car yang baru
	public void case1() {
		String carName;
		String carType;
		int carPrice;
		int carTopSpeed;
		int carTurbo;

		System.out.println("Input Car Name : ");
		carName = sc.nextLine();
		do {
			System.out.println("Input Car Type [Minibus | Sportcar] : ");
			carType = sc.nextLine();
		} while (!carType.equals("Minibus") && !carType.equals("Sportcar"));

		if(carType.equals("Sportcar")) {
			System.out.println("Input Car Top Speed in KM : ");
			carTopSpeed = sc.nextInt();
			sc.nextLine();
			do {
				System.out.println("Input Car Turbo [1-3] : ");
				carTurbo = sc.nextInt();
				sc.nextLine();
			} while (carTurbo < 1 || carTurbo > 3);

			System.out.println("Input Car Price in $: ");
			carPrice = sc.nextInt();
			sc.nextLine();
//Memasukan objek Sportcar ke arraylist
			arr.add(new Sportcar(carName, carType, carPrice, carTopSpeed, carTurbo));
		}else {
			System.out.println("Input Car Top Speed in KM : ");
			carTopSpeed = sc.nextInt();
			sc.nextLine();

			System.out.println("Input Car Price Rupiah: ");
			carPrice = sc.nextInt();
			sc.nextLine();
// Memasukan objek Minibus ke arraylist
			arr.add(new Minibus(carName, carType, carPrice, carTopSpeed));
		}

		System.out.println("Success Input New Car !!");
		sc.nextLine();
	}
//Method untuk menampilkan list dari Car yang sudah di input
	public void case2() {
		if(arr.isEmpty()) {
			System.out.println("There is No Car");
			sc.nextLine();
		}else {


			System.out.println("===============================================================");
			for (int i = 0; i < arr.size(); i++) {
				System.out.println("NO : " + (i+1));
				System.out.println("Car Name : " + arr.get(i).getCarName());
				System.out.println("Car Type : " + arr.get(i).getCarType());
				System.out.println("Car Top Speed in KM : " + arr.get(i).getCarTopSpeed());
				System.out.println("Car Price in Rupiah : " + arr.get(i).getCarPrice());
				System.out.println("===============================================================");
			}
		}
	}
//Method untuk mengecek suara Mobil
	public void case3() {
		if(arr.isEmpty()) {
			System.out.println("There is no Car");
			sc.nextLine();
		}else {
			Minibus  m;
			Sportcar s;
			int choice = 0;

			case2();
			System.out.println("Choose Car To Test The Sound  [1-" +arr.size()+"] : ");
			choice = sc.nextInt();
			sc.nextLine();
			choice -= 1;

			if(arr.get(choice) instanceof Sportcar) {
				s = (Sportcar) arr.get(choice);
				s.carSound();
			}else {
				m = (Minibus) arr.get(choice);
				m.carSound();
			}

			sc.nextLine();
		}

	}
// Method untuk menghapus semua mobil
	public void case4() {
		if(arr.isEmpty()) {
			System.out.println("There is no Car");
			sc.nextLine();
		}else {
			arr.removeAll(arr);
			System.out.println("All Car Sold");
		}
	}

	public void case5() {
		System.out.println(" |\\/\\/\\/|  ");
		System.out.println(" |      |  ");
		System.out.println(" |      |  ");
		System.out.println(" | (o)(o)  ");
		System.out.println(" C      _) ");
		System.out.println("  | ,___|  ");
		System.out.println("  |   /    ");
		System.out.println(" /____\\    ");
		System.out.println("/      \\");
		System.out.println("Thank You LC022 :D");
	}


	public Main() {
		cls();
		title();
		sc.nextLine();
		do {
			cls();
			menu();
			menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {

			case 1 :
				cls();
				case1();
				break;

			case 2 : 
				cls();
				case2();
				sc.nextLine();
				break;

			case 3 : 
				cls();
				case3();
				break;

			case 4 : 
				cls();
				case4();
				break;

			case 5 : 
				cls();
				case5();
				break;
			}
		}while(menu != 5);


	}

	public static void main(String[] args) {
		new Main();

	}

}
