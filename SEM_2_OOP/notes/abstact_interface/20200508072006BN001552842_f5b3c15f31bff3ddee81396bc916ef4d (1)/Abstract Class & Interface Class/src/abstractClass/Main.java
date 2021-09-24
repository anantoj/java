package abstractClass;

import java.util.Scanner;

public class Main {

	public Scanner sc = new Scanner(System.in);
	String pilih = "";
	public int km = 0;
	
	Taxi t ;
	
	public Main() {
		do {
			System.out.println("Tranquil Express");
			System.out.println("1. Classic Taxi");
			System.out.println("2. Limousine Taxi");
			System.out.println("3. Exit");
			System.out.print("Choose your taxi: ");
			pilih = sc.nextLine();
			
			if(pilih.equals("1")){
				System.out.print("Total KM: ");
				km = sc.nextInt();
				sc.nextLine();
				t = new Classic();
				System.out.println("Payment: " + t.hitungBiaya(km));
			}else if(pilih.equals("2")){
				System.out.print("Total KM: ");
				km = sc.nextInt();
				sc.nextLine();
				t = new Limo();
				System.out.println("Payment: " + t.hitungBiaya(km));
			}else if(pilih.equals("3")){
				System.out.println("Terima kasih");
				System.exit(0);
			}else{
				System.out.println("Menu salah. silahkan coba lagi");
			}
			sc.nextLine();
			
		} while (true);
	}
	
	public static void main (String[]args){
		new Main();
	}

}