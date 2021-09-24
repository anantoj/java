package meeting3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;


public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Array Initialization
		int [] arr;
		int arr1 [];
		int array [] = {1,2,3,4,5};
	
		// Most common  initialization
		int number [] = new int [5];
		number[0] = 2;
		
		// 2d String array initialization
		String[][] name = new String[2][3];
		
		for (int i = 0; i < name.length; i++) {
			for (int j = 0; j < name[i].length; j++) {
				System.out.printf("Who will sit at [%d][%d]: ", i,j);
				name[i][j] = scan.nextLine();
			}
		}
		
		for (int i = 0; i < name.length; i++) {
			for (int j = 0; j < name[i].length; j++) {
				System.out.printf("|%s", name[i][j]);
			}
			System.out.println("");
		}
		
		System.out.printf("\n\n\n\n\n\n\n");
		
		Vector<Integer> vec = new Vector<>();
		
		vec.add(1);
		vec.add(2);
		vec.add(2, 3); // adds element 3 to index 2
		
		for (int i = 0; i < vec.size(); i++) {
			System.out.println("Vector index " + i + ": " + vec.get(i));
		}
		
		vec.remove(0);
		System.out.println("After index elememt at index 0 is removed");
		for (int i = 0; i < vec.size(); i++) {
			System.out.println("Vector index " + i + ": " + vec.get(i));
		}
		
		vec.set(1, 5);
		System.out.println("After list is updated");
		for (int i = 0; i < vec.size(); i++) {
			System.out.println("Vector index " + i + ": " + vec.get(i));
		}
		
		//---------------------------------------------------------------
		
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n");
		
		ArrayList <String> mhs = new ArrayList();
		
		int menu = 0;
		do {
			System.out.println("1. Input Name");
			System.out.println("2. View");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			try {
				menu = scan.nextInt();
				scan.nextLine();
	;		} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Input Invalid");
			}
			int index;
			switch (menu) {
			case 1:
				System.out.print("Input Name: ");
				mhs.add(scan.nextLine());
				break;
			case 2:
				System.out.println("Input index: ");;
				index = scan.nextInt();
				scan.nextLine();
				System.out.println(mhs.get(index));
				break;
			case 3:
				System.out.println("Input index: ");
				index = scan.nextInt();
				scan.nextLine();
				System.out.println("Input new Name: ");
				String element = scan.nextLine();
				mhs.set(index, element);
				break;
			case 4:
				System.out.println("Input Name to be deleted");
				String tmp = scan.nextLine();			
				mhs.remove(tmp);
				break;
			default:
				break;
				
			}
		}while (menu != 5);
		
		for (int i = 0; i < mhs.size(); i++) {
			System.out.println(i + " " + mhs.get(i));
		}
		
	}
}
