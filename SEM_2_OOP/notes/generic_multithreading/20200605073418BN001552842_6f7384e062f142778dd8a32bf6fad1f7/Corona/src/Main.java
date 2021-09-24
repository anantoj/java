import java.util.Scanner;
import java.util.Vector;

//Membuat thread dengan cara implemets runnable
public class Main implements Runnable{

	public static int virus;
	public static int patient;
	
	int level;
	int max_virus;
	int max_patient;
	int max_list_size;
	boolean print;
	
	Scanner scan = new Scanner(System.in);
	Vector<Person> helper_list = new Vector<>(); //Array of thread
	
	//Thread 1
	Thread start_game = new Thread(new Runnable() {
		//Saat start maka run ini akan dijalankan
		@Override
		public void run() {
			init();
			
			while(true){
				//Validasi
				if(virus < 0) virus = 0;
				if(patient > max_patient) patient = max_patient;
				
				//Leveling
				if(virus >= max_virus){
					cls();
					System.out.println("Arendelle was destroyed by viruses");
					System.out.println("Thank you for saving us :(");
					System.exit(0);
				}
				if(patient <= 0){
					level++;
					init();
				}
				
				remove_helper_list();
			}
		}
		
		private void remove_helper_list(){
			if(helper_list.isEmpty()) return;
			if (helper_list.get(0).getRemaining_time() <= 0) helper_list.remove(0);
		}
		
		private void init() {
			virus = 0;
			patient = level*10;
			max_patient = patient;
			max_virus = patient+(patient/5);
			max_list_size = 5 + level/5;
			helper_list.clear();
		}
	});
	
	void cls(){
		for (int i = 0; i < 25; i++) {
			System.out.println("");
		}
	}
	
	void save_arendelle(){
		int ch;
		
		do{
			cls();
			System.out.println("1. Kill viruses");
			System.out.println("2. Heal people");
			System.out.print("Choose [0 for back] : ");
			ch = scan.nextInt();
			scan.nextLine();
		} while(ch < 0 || ch > 2);
		
		cls();
		if(ch == 0) return;
		if(helper_list.size() == max_list_size){
			System.out.println("Arendelle has enough helpers");
			scan.nextLine();
			return;
		}
		
		if(ch == 1 && virus == 0){
			System.out.println("There is no virus!");
			System.out.println("Let's heal the people");
			scan.nextLine();
			return;
		}
		
		String helper_name;
		int work_time;
		Person helper;
		
		do{
			System.out.print("Input your name [3-15 chars] : ");
			helper_name = scan.nextLine();
		} while (helper_name.length() < 3 || helper_name.length() > 15);
		
		do{
			System.out.print("Input your working time [10 - "+(max_patient*5)+", multiple 10] : ");
			work_time = scan.nextInt();
			scan.nextLine();
		} while( work_time < 10 || work_time > (max_patient*5) || work_time%10 != 0);
		
		
		if(ch == 1) helper = new Scientist(helper_name, work_time);
		else helper = new Doctor(helper_name, work_time);
		
		helper_list.add(helper);
		
		//Start Threading
		helper.start();
	}
	
	void see_helpers(){
		cls();
		
		System.out.println("Helpers : "+helper_list.size()+"/"+max_list_size);
		System.out.println("");
		for (Person person : helper_list) {
			System.out.println("Name : "+person.getHelper_name());
			System.out.println("Working time : "+person.getWork_time()+" hours");
			System.out.println("Remaining time : "+person.getRemaining_time()/1000+" hours");
			System.out.println("");
		}
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	public Main() {
		// TODO Auto-generated constructor stub
		int menu = 0;
		level = 1;
		print = true;
		start_game.start(); //Memulai thread
		
		//Thread 2 untuk update status 3 detik sekali
		Thread update_status = new Thread(this); //Diisi this, karena Main ini sudah implements Runnable
		update_status.start(); 
		
		do{
			menu = scan.nextInt();
			scan.nextLine();
			print = false;
			switch (menu) {
			case 1:
				save_arendelle();
				System.out.println("Loading...");
				break;
			case 2:
				see_helpers();
				System.out.println("Loading...");
				break;
			}
			print = true;
		} while(menu != 3);
		
		cls();
		System.out.println("Good bye Arendelle :(");
		System.out.println("Thank you for saving us!");
		System.exit(0);
	}
	
	void print_menu(){
		cls();
		System.out.println("\tSave-Arendelle");
		System.out.println("==============================");
		System.out.println("Level   : "+level);
		System.out.println("Virus   : "+virus+"/"+max_virus);
		System.out.println("Patient : "+patient);
		System.out.println("==============================");
		System.out.println("");
		System.out.println("1. Get help");
		System.out.println("2. See helpers");
		System.out.println("3. Exit");
		System.out.print(">> ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(print) print_menu();
			try {
				Thread.sleep(3000); //3 detik
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
