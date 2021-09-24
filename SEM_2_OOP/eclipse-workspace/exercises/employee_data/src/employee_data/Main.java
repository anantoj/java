package employee_data;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList<Employee> employeeList = new ArrayList<>();

	public Main(){
		int menu = 0;
		do{
			menu = getMenu();
			switch (menu) {
				case 1:
					addEmployee();	
					break;
				case 2:
					viewEmployee();
					break;
				case 3:
					resign();
					break;
				default:
					break;
			}
			System.out.println("Press any enter to continue...");
			scan.nextLine();
		} while (menu != 4);
	}

	public void resign(){
		if (employeeList.isEmpty()){
			System.out.println("There is no employee data in the list");
		}
		else{
			viewEmployee();
			int index = 0;
			do{	
				try {
					System.out.printf("Input employee number that want to resign[1..%d]: ", employeeList.size());
					index = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
			}while (index < 1 || index > employeeList.size());
			if (employeeList.get(index-1).getIsActive()){
				employeeList.get(index-1).setIsActive(false);
				System.out.println(employeeList.get(index-1).getName() + " is resigning...");
			}
			else{
				System.out.println("Employee has already resigned!");
			}
			System.out.println("");
			
		}
	}

	public void viewEmployee(){
		if (employeeList.isEmpty()){
			return;
		}
		for (int i = 0; i < employeeList.size(); i++){
			System.out.println("Employee no." + (i+1));
			if (employeeList.get(i) instanceof PartTimeEmployee){
				System.out.println("Part Time Employee");
			} 
			else{
				System.out.println("Full Time Employee");
			}
			System.out.println("==================");
			if (employeeList.get(i).getIsActive()){
				System.out.println("Status: active");
			}
			else{
				System.out.println("Status: not active");
			}
			System.out.println("Name: " + employeeList.get(i).getName());
			System.out.println("Age: " +employeeList.get(i).getAge());
			System.out.println("Role: " +employeeList.get(i).getRole());

			if (employeeList.get(i) instanceof PartTimeEmployee){
				PartTimeEmployee tmp = (PartTimeEmployee)employeeList.get(i);		
				System.out.println("Pay per hour: " + tmp.getPayHour());
				System.out.println("Working hour per week: " + tmp.getWorkHour());
				System.out.println("Salary per month: " + tmp.getPayHour() * tmp.getWorkHour());
			} 
			else{
				FullTimeEmployee tmp = (FullTimeEmployee)employeeList.get(i);
				System.out.println("Base salary per month: " + tmp.getSalary());
			}
			System.out.println("");
		}
	}

	public void addEmployee(){
		String name = "";
		do {
			System.out.print("Input employee name[must be more than 3 characters]: ");
			name = scan.nextLine();
		} while (name.length()<= 3);
		
		int age = 0;
		do {
			try {
				System.out.print("Input employee age[>=17]: ");
				age = scan.nextInt();
				scan.nextLine();
			} catch ( Exception e) {
				//TODO: handle exception
				scan.nextLine();
			}
		} while (age < 17);

		String role = "";
		do {
			System.out.print("Input employee role[Assistant | Programmer](Case Sensitive): ");
			role = scan.nextLine();
		} while (!role.equals("Assistant") && !role.equals("Programmer"));

		String type = "";
		do {
			System.out.print("Input employee type[PartTime | FullTime](Case Sensitive): ");
			type = scan.nextLine();
		} while (!type.equals("PartTime") && !type.equals("FullTime"));

		if (type.equals("PartTime")){
			int payHour = 0;
			do {
				try {
					System.out.print("Input pay per hour [>=10000]: ");
					payHour = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
			} while (payHour < 10000);
			
			int workHour = 0;
			do {
				try {
					System.out.print("Input working hour per week[>0]: ");
					workHour = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
			} while (workHour <= 0);

			employeeList.add(new PartTimeEmployee(name, age, role, payHour, workHour));
		}
		else{
			int salary = 0;
			do {
				try {
					System.out.print("Input base salary[>=10000]: ");
					salary = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					//TODO: handle exception
					scan.nextLine();
				}
			} while (salary < 10000);

			employeeList.add(new FullTimeEmployee(name, age, role, salary));
		}

		System.out.println("Success insert employee data");
		System.out.println("");
	}

	public int getMenu() {
		System.out.println("ABC EMPLOYEE DATA");
		System.out.println("=================");
		System.out.println("1. Add employee");
		System.out.println("2. View employee");
		System.out.println("3. Resign");
		System.out.println("4. Exit");
		int menu = 0;
		do {
			try {
				System.out.print("Choice: ");
				menu = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
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
