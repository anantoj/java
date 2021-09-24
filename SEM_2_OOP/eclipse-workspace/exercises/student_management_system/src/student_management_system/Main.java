package student_management_system;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList<Student> studentList = new ArrayList<Student>();
	
	public Main() {		
		int menu = 0;
		
		do {
			menu = getMenu();
			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				delete();
				break;
			case 3:
				view();
				break;
			default:
				break;
			}
		}while (menu != 4);
	}
	
	public void view() {
		if (studentList.isEmpty()) {
			System.out.println("List of students is empty");
			return;
		}
		System.out.println("List of student:");
		System.out.println("================");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i).getName());
		}
	}
	
	public void delete() {
		System.out.print("Input nim: ");
		String nim = "";
		nim = scan.nextLine();
		Student tmp;
		for (int i = 0; i < studentList.size(); i++) {
			tmp = studentList.get(i);
			if (tmp.getNim().equals(nim)) {
				System.out.printf("%s(%s) has been deleted\n", tmp.getName(), tmp.getNim());
				studentList.remove(i);
				return;
			}
		}
		System.out.println(nim + " you entered is not found");
		
	}
	
	public void add() {
		String nim = "", name = "", phone = "";
		
		do {
			System.out.print("NIM (10 DIGITS): ");
			nim = scan.nextLine();
		}while(nim.length() != 10);
		
		System.out.print("Name: ");
		name = scan.nextLine();
		System.out.print("Phone Number: ");
		phone = scan.nextLine();	
		Student newStudent = new Student(nim, name, phone);
		studentList.add(newStudent);
	}
	
	public int getMenu() {
		System.out.printf("\n\n\n\n\n");
		System.out.println("Student Mangement System");
		System.out.println("========================");
		System.out.println("1. Add Student");
		System.out.println("2. Delete Student");
		System.out.println("3. View Student");
		System.out.println("4. Exit");
		int menu = 0;
		do {
			try {
				System.out.print("Input: ");
				menu = scan.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				scan.nextLine();
			}
		}while (menu == 0);
		return menu;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
