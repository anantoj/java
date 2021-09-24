
//Step 3. extends superClass ke subClass
	//caranya gunakan keyword "extends (Nama SuperClassnya)"
public class Sportcar extends Car{
	//Stepp 4. Buat variabel penampungnya seperti pada contoh di bawah
	private int carPriceDollar = super.getCarPrice();
	private int kursRupiah = 15000;
	private int turbo;
	private int topSpeed = super.getCarTopSpeed();
	
	
	//Step 5. Buat constructornya , dan sesuaikan dengan paramternya juga
	public Sportcar(String carName, String carType, int carPrice , int carTopSpeed , int turbo) {
		super(carName, carType, carPrice, carTopSpeed);
		this.turbo = turbo;
		// TODO Auto-generated constructor stub
	}
	
	//Step 6. Buat method Overridenya
		/*caranya ketik method yang ada pada superClass
		 *contohnya ketikk "carSound" lalu ctrl + space
		 *Kemudian ubah isi methodnya (ini salah satu contoh yang dimaksud berbeda-beda tapi namanya sama)
		 *Lakukan hal yang sama jika ingin meng overide method yang lainnya*/
	
	@Override
	public void carSound() {
		// TODO Auto-generated method stub
		System.out.println(" Car Sound : Bremm Bremm......");
	}
	
	@Override
	public int getCarPrice() {
		// TODO Auto-generated method stub
		return carPriceDollar*kursRupiah;
	}

	@Override
	public int getCarTopSpeed() {
		// TODO Auto-generated method stub
		return turbo*topSpeed;
	}
	//Step 7. Ulangi pada saat membuat subClass lainnya.
	//Step 8. Buat Main Class (checklist public static void main + constructor)
		//Buka Main Class
}
