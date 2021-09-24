import bangun.BangunDatar;
import bangun.Persegi;
import bangun.Segitiga;

//panduan membuat polymorphism
//Sebelum melihat isi dari MainClass
//Step 0. Buka kelas BangunDatas

public class Main {
	
	public Main() {
		//buat object dari class BangunDatar, Persegi, Segitiga
		BangunDatar bangunDatar = new BangunDatar();
		
		//Object class Persegi masukan parameter (sisi)
		Persegi persegi = new Persegi(8);
		
		Segitiga segitiga = new Segitiga(4,5);
		
		System.out.println("PERSEGI");
		// memanggil method keliling 
		bangunDatar.keliling();
		System.out.println("Keliling persegi adalah " + persegi.keliling()+"\n");
		
		// memanggil method luas
		bangunDatar.luas();
		System.out.println("Luas persegi adalah " + persegi.luas() + "\n\n");
	
		
		System.out.println("Segitiga");
		// memanggil method luas 
		bangunDatar.luas();
		System.out.println("Keliling persegi adalah " + segitiga.luas()+"\n");
		
		
	}

	public static void main(String[] args) {
		new Main();

	}

}
