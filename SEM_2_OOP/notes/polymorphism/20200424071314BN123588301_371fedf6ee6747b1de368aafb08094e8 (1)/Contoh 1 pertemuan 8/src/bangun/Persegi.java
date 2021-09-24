package bangun;

//Step 3. extends superClass ke subClass
	//caranya gunakan keyword "extends (Nama SuperClassnya)"
public class Persegi extends BangunDatar{
	
//Stepp 4. Buat variabel penampung untuk sisi dari Persegi
	int sisi;

//Step 5. Buat constructor 
	/* Intinya, constructor dengan parameter sisi
	 * Akan menerima variabel integer
	 * this.sisi = sisi -> maksudnya jika kita membuat object pada class Main 
	 * cthnya Persegi persegi = new Persegi(int s) -> akan meminta parameter integer
	 * lalu integer s yang diterima akan ditampung pada int sisi*/
	
	public Persegi(int s){
		this.sisi = s;
	}
	
//Step 6. Buat method Overridenya
	/*caranya ketik method yang ada pada superClass
	 *contohnya ketikk "luas" lalu ctrl + space
	 *Kemudian ubah isi methodnya (ini salah satu contoh yang dimaksud berbeda-beda tapi namanya sama)
	 *Karena Luas persegi, maka returnnya -> return this.sisi*this.sisi
	 *Buat juga demikian untuk kelilingnya*/
	
	@Override
	public float luas(){
		return this.sisi*this.sisi;
	}
	
	@Override
	public float keliling() {
	
		return this.sisi*4;
	}
//Step 7. Ulangi pada saat membuat subClass lainnya.
//Step 8. Buat Main Class (checklist public static void main + constructor)
	//Buka Main Class
}
