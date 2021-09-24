package even_odd;

import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);

	public Main() {
		// TODO Auto-generated constructor stub
		int even = 0, odd = 0;

		do {
			try {
				System.out.print("How many numbers of even number you want to display?[>0]: ");
				even = scan.nextInt();
				scan.nextLine();			
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		} while (even <= 0);

		do {
			try {
				System.out.print("How many numbers of odd number you want to display?[>0]: ");
				odd = scan.nextInt();
				scan.nextLine();			
			} catch (Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		} while (odd<= 0);
		Even e = new Even(even);
		Odd o = new Odd(odd);

		Thread eThread = new Thread(e);
		Thread oThread = new Thread(o);
		eThread.start();
		oThread.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
