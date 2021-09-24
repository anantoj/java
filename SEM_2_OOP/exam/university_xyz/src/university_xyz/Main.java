package university_xyz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class Main implements Runnable{
	Scanner scan = new Scanner(System.in);
	Vector<Mahasiswa> mhs_list = new Vector<>();
	Vector<Dosen> dosen_list = new Vector<>();
	Vector<Administrator> admin_list = new Vector<>();
	int runTime = 0;
	boolean print_main;

	public Main() {
		int menu = 0;
		Thread t = new Thread(this);
		t.start();
		do {
			print_main = true;
			do {
				try {
					menu = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}
			} while (menu < 1 || menu > 5);
			print_main = false;
			if (menu == 1){
				if (mhs_list.isEmpty()){
					System.out.println("There are no Mahasiswa..");
					System.out.println("Press Enter to Continue..");
					scan.nextLine();
				}
				else{
					int choice = get_vector(mhs_list);
					Mahasiswa e = mhs_list.get(choice -1);
					int mhs_menu = 0;
					do {
						mhs_menu = get_mhs_menu();
						switch (mhs_menu) {
							case 1:
								System.out.println("Name: " + e.getName());
								System.out.println("Address: " + e.getAddress());
								System.out.println("Phone: " + e.getPhone());
								System.out.println("Email: " + e.getEmail());
								System.out.println("Year: " + e.getYear());
								break;
							case 2:
								String address = "";
								System.out.println("Enter new address: ");
								address = scan.nextLine();
								e.setAddress(address);
								break;
							case 3:
								String phone = "";
			
								boolean isNumeric = false;
						
								while (isNumeric == false){
									System.out.print("Enter new phone number: ");
									phone = scan.nextLine();
									isNumeric = phone.matches("-?\\d+(\\.\\d+)?");
								}
								e.setPhone(phone);
								break;
							case 4:
								String email = "";
								email = scan.nextLine();
								e.setEmail(email);
								break;
							default:
								break;
						}
						
					} while (mhs_menu != 5);
				}
			}
			else if (menu == 2){
				if (dosen_list.isEmpty()){
					System.out.println("There are no Dosen..");
					System.out.println("Press Enter to Continue..");
					scan.nextLine();
				}
				else{
					int choice = get_vector(dosen_list);
					Dosen e = dosen_list.get(choice -1);
					int dosen_menu = 0;
					do {
						dosen_menu = get_mhs_menu();
						switch (dosen_menu) {
							case 1:
								System.out.println("Name: " + e.getName());
								System.out.println("Address: " + e.getAddress());
								System.out.println("Phone: " + e.getPhone());
								System.out.println("Email: " + e.getEmail());
								System.out.println("Work Location: " + e.getLocation());
								System.out.println("Salary: Rp." + e.getSalary());
								System.out.println("Work Date: " + e.printDate());
								System.out.println("Work Hours: " + e.getHours());
								System.out.println("Faculty Level: " + e.getLevel());
								break;
							case 2:
								String address = "";
								System.out.println("Enter new address: ");
								address = scan.nextLine();
								e.setAddress(address);
								break;
							case 3:
								String phone = "";
			
								boolean isNumeric = false;
						
								while (isNumeric == false){
									System.out.print("Enter new phone number: ");
									phone = scan.nextLine();
									isNumeric = phone.matches("-?\\d+(\\.\\d+)?");
								}
								e.setPhone(phone);
								break;
							case 4:
								String email = "";
								email = scan.nextLine();
								e.setEmail(email);
								break;
							default:
								break;
						}
						
					} while (dosen_menu != 5);
				}
			}
			else if (menu == 3){
				if (admin_list.isEmpty()){
					System.out.println("You must create an Administrator account! ");
					add_admin();
				}
				else{
					int choice = get_vector(admin_list);
					Administrator e = admin_list.get(choice -1);
					int adminMenu = 0;
					do {
						adminMenu = get_admin_menu();
						switch (adminMenu) {
							case 1:
								System.out.println("Name: " + e.getName());
								System.out.println("Address: " + e.getAddress());
								System.out.println("Phone: " + e.getPhone());
								System.out.println("Email: " + e.getEmail());
								System.out.println("Work Location: " + e.getLocation());
								System.out.println("Salary: Rp." + e.getSalary());
								System.out.println("Work Date: " + e.printDate());
								System.out.println("Title: " + e.getTitle());
								break;
							case 2:
								add_mhs();
								break;
							case 3:
								add_dosen();
								break;
							case 4:
								add_admin();
								break;
							case 5:
								for (Mahasiswa mhs : mhs_list) {
									System.out.println(mhs.getName() + " " + mhs.getYear());
								}
								break;
							case 6: 
								for (Dosen dsn: dosen_list) {
									System.out.println(dsn.getName() + " " + dsn.getLocation() + " " + dsn.getLevel());
								}
								break;
							case 7:
								for (Administrator admin : admin_list) {
									System.out.println(admin.getName() + " " + admin.getLocation() + " " + admin.getTitle());
								}
								break;
							case 8:
								for (Mahasiswa mhs : mhs_list) {
									System.out.println(mhs.toString());
								}
								for (Dosen dsn: dosen_list) {
									System.out.println(dsn.toString());
								}
								for (Administrator admin : admin_list) {
									System.out.println(admin.toString());
								}
								break;
							default:
								break;
						}
						
					} while (adminMenu != 9);
				}
			}
		} while (menu != 4);
		System.exit(0);
	}

	public void cls(){
		for (int i = 0 ; i < 25; i++){
			System.out.println("");
		}
	}

	public void add_dosen(){
		System.out.print("Enter your name: ");
		String name = scan.nextLine();

		System.out.print("Enter your address: ");
		String address = scan.nextLine();

		String phone = "";
		
		boolean isNumeric = false;

		while (isNumeric == false){
			System.out.print("Enter your phone number: ");
			phone = scan.nextLine();
			isNumeric = phone.matches("-?\\d+(\\.\\d+)?");
		}
		System.out.print("Enter your email: ");
		String email = scan.nextLine();

		String location = "";
		do {
			System.out.print("Enter your work location [Kemanggisan | Alam Sutra | Bekasi | Bandung | Malang](case sensitive): ");
			location = scan.nextLine();
		} while (!location.equals("Kemanggisan") && !location.equals("Alam Sutra")  && !location.equals("Bekasi")  && !location.equals("Bandung")  && !location.equals("Malang"));

		int salary = 0;

		do {
			try {
				System.out.println("Enter your salary: ");
				salary = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (salary < 0);	

		String d = "";
		Calendar date = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
		while(true){
			System.out.print("Enter date [date month year]: ");
			try {
				d = scan.nextLine();
				date.setTime(format.parse(d));
				break;
			} catch (Exception e) {

			}
		}

		int hours = 0;

		do {
			try {
				System.out.print("Enter your working hours: ");
				salary = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (hours < 0);

		String level = "";
		do {
			System.out.print("Enter your level [Asisten Ahli | Lektor | Lektor Kepala | Professor](case sensitive): ");
			level = scan.nextLine();
		} while (!level.equals("Asisten Ahli") && !level.equals("Lektor") && !level.equals("Lektor Kepala") && !level.equals("Professor"));

		Dosen dsn = new Dosen(name, address, phone, email, location, salary, date, hours, level);
		dosen_list.add(dsn);
	}

	public void add_mhs(){
		System.out.print("Enter your name: ");
		String name = scan.nextLine();

		System.out.print("Enter your address: ");
		String address = scan.nextLine();

		String phone = "";
		
		boolean isNumeric = false;

		while (isNumeric == false){
			System.out.print("Enter your phone number: ");
			phone = scan.nextLine();
			isNumeric = phone.matches("-?\\d+(\\.\\d+)?");
		}
		System.out.print("Enter your email: ");
		String email = scan.nextLine();

		int year = 0;
		do {
			try {
				System.out.print("Enter your year[2015 - 2020]: ");
				year = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (year < 2015 || year > 2020);
		Mahasiswa mhs = new Mahasiswa(name, address, phone, email, year);
		mhs_list.add(mhs);
	}

	public int get_admin_menu(){
		System.out.println("1. Profile");
		System.out.println("2. Add Mahasiswa");
		System.out.println("3. Add Dosen");
		System.out.println("4. Add Administrator");
		System.out.println("5. List all Mahasiswa");
		System.out.println("6. List all Dosen");
		System.out.println("7. List all Administrator");
		System.out.println("8. List all user");
		System.out.println("9. Change user");
		int choice = 0;
		do {
			try {
				System.out.print("Choice: ");
				choice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (choice < 1 || choice > 9);
		return choice;
	}

	public <E extends Orang> void printList(Vector<E > list){
		int index = 1;
		for (E e : list) {
			System.out.println(index + ". " + e.getName());
			index++;
		}
	}

	public <E extends Orang> int get_vector(Vector<E > list){
		int index = 1;
		System.out.println("Log in as:");
		for (E e : list) {
			System.out.println(index + ". " + e.getName());
			index++;
		}
		int choice = 0;
		do {
		try {
			choice = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			scan.nextLine();
		}
		} while (choice < 1 || choice > list.size());
		return choice;
	}

	public void add_admin(){
		System.out.print("Enter your name: ");
		String name = scan.nextLine();

		System.out.print("Enter your address: ");
		String address = scan.nextLine();

		String phone = "";
		
		boolean isNumeric = false;

		while (isNumeric == false){
			System.out.print("Enter your phone number: ");
			phone = scan.nextLine();
			isNumeric = phone.matches("-?\\d+(\\.\\d+)?");
		}
		System.out.print("Enter your email: ");
		String email = scan.nextLine();

		String location = "";
		do {
			System.out.print("Enter your work location [Kemanggisan | Alam Sutra | Bekasi | Bandung | Malang](case sensitive): ");
			location = scan.nextLine();
		} while (!location.equals("Kemanggisan") && !location.equals("Alam Sutra")  && !location.equals("Bekasi")  && !location.equals("Bandung")  && !location.equals("Malang"));

		int salary = 0;

		do {
			try {
				System.out.print("Enter your salary: ");
				salary = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (salary < 0);	

		String d = "";
		Calendar date = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
		while(true){
			System.out.print("Enter date [date month year]: ");
			try {
				d = scan.nextLine();
				date.setTime(format.parse(d));
				break;
			} catch (Exception e) {
			}
		}

		String title = "";
		do {
			System.out.print("Enter your title [Staff | Supervisor | Manager | Kepala Divisi | Direksi](case sensitive): ");
			title = scan.nextLine();
		} while (!title.equals("Staff") && !title.equals("Supervisor") && !title.equals("Manager") && !title.equals("Kepala Divisi") && !title.equals("Direksi"));
		
		Administrator a = new Administrator(name, address, phone, email, location, salary, date, title);
		
		admin_list.add(a);
	}

	public void print_main_menu(){
		System.out.println("Program Run Time: " + runTime + " s");
		System.out.println("1. Log in as Mahasiswa");
		System.out.println("2. Log in as Dosen");
		System.out.println("3. Log in as Administrator");
		System.out.println("4. Exit");
		System.out.println("Choice: ");
	}

	public int get_mhs_menu(){
		System.out.println("1. Profile");
		System.out.println("2. Change Address");
		System.out.println("3. Change phone number");
		System.out.println("4. Change email");
		System.out.println("5. Change user");
		
		int choice = 0;
		do {
			try {
				System.out.print("Choice: ");
				choice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (choice < 1 || choice > 5);
		return choice;
	}

	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void run(){
		while(true){
			if (print_main){
				cls();
				print_main_menu();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			runTime++;
		}
	}

}
