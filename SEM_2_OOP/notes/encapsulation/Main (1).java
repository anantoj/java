package pert_5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList<Mahasiswa> mhsList = new ArrayList<>();
	
	public Main() {
		/**
 		 * NOTE : hapus //yang ada dikanan kalau ingin dicoba
 		 */

		// ## Cara penggunaan object
//		Mahasiswa mhs = new Mahasiswa("will" , "2000");  //membuat object
//		mhs.nama = "william";  //akses atribute object jika public
//		mhs.nim = "22000000";
//		
//		System.out.println(mhs.nama);   //akses atribut jika tidak menggunakan encapsulation
//		System.out.println(mhs.getNama());   //Menggunakan get untuk mengambil data jika sudah menggunakan encap
//		mhs.printIdentitas();
		
		// ## Latihan
		/**
 		 * NOTE : Menu seperti biasa tapi disederhanain menggunakan method
 		 */
		int menu = 0;
		do{
			menu();
			menu = scan.nextInt();
			scan.nextLine();
			
			switch(menu){
				case 1: insertMahasiswa();
					break;
				case 2: viewMahasiswa();
					break;
				case 3: deleteMahasiswa();
					break;
				case 4: updateMahasiswa();
					break;
			}
		}while(menu != 5);
		 System.out.println("end of program");
	}
	
	/**
	 * NOTE : update
	 * mirip seperti delete, ambil dulu indexnya
	 * truss siapin temp attribut buat disimpan data inputan barunya
	 * get index ke berapa dalam list, truss ubah attributnya
	 */
	private void updateMahasiswa() {
		// TODO Auto-generated method stub
		viewMahasiswa();
		System.out.println();
		int index = 0;
		do{
			System.out.print("input index : ");
			index = scan.nextInt();
			scan.nextLine();
		}while(index < 1 || index > mhsList.size());
		
		String nama = "" , nim = "";
		System.out.print("insert nama : ");
		nama = scan.nextLine();
		System.out.print("insert nim : ");
		nim = scan.nextLine();
		
		mhsList.get(index-1).setNama(nama);
		mhsList.get(index-1).setNim(nim);
		
		System.out.println("success...");
		scan.nextLine();
	}
	
	/**
	 * NOTE : delete dengan cara mencari indexnya dulu
	 * input indexnya divalidasi sesuai besar sizenya
	 * karena dari list itu seperti array (mulai dari 0), maka index yang diinput di -1
	 */
	private void deleteMahasiswa() {
		// TODO Auto-generated method stub
		viewMahasiswa();
		System.out.println();
		int index = 0;
		do{
			System.out.print("input index : ");
			index = scan.nextInt();
			scan.nextLine();
		}while(index < 1 || index > mhsList.size());
		mhsList.remove(index-1);
		
		System.out.println("success...");
		scan.nextLine();
	}
	
	/**
	 * NOTE : view dengan looping kaya biasa
	 * ambil objectnya setiap list truss get attributnya (bisa getNama / getNim)
	 */
	private void viewMahasiswa() {
		// TODO Auto-generated method stub
		for (int i = 0; i < mhsList.size(); i++) {
			System.out.println((i+1) + ". " + mhsList.get(i).getNama() + " / " + mhsList.get(i).getNim());
		}
		System.out.println("");
	}
	
	/**
	 * NOTE : insert kedalam list of object
	 * object yang boleh dimasukin ke list hanya dengan class Mahasiswa
	 */
	private void insertMahasiswa() {
		// TODO Auto-generated method stub
		String nama = "" , nim = "";
		System.out.print("insert nama : ");
		nama = scan.nextLine();
		System.out.print("insert nim : ");
		nim = scan.nextLine();
		
		Mahasiswa mhs = new Mahasiswa(nama, nim);
		mhsList.add(mhs);
		
		System.out.println("success....");
		scan.nextLine();
	}

	private void menu() {
		System.out.println("List");
		System.out.println("1. insert");
		System.out.println("2. view");
		System.out.println("3. delete");
		System.out.println("4. update");
		System.out.println("5. exit");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
