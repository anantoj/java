
public class Car {
	//Step 1. buat superClass (tidak usah checklist public static void main)
		/* Pada superClass, buat method yang dimiliki oleh setiap mobil dalam soal ini
		 * Perbedaannya yaitu suara yang berbeda pada setiap SubClassnya walaupun nama methodnya sama
		 * Kata Kuncinya "Berbeda-beda tapi Namanya Sama"  */
	
	private String carName;
	private String carType;
	private int carPrice;
	int carTopSpeed;
	
	
	public Car(String carName, String carType, int carPrice, int carTopSpeed) {
		super();
		this.carName = carName;
		this.carType = carType;
		this.carPrice = carPrice;
		this.carTopSpeed = carTopSpeed;
	}
	
	//Contohnya tiap mobil memiliki method" seperti dibawah ini
	
	public void carSound() {
		System.out.println("Car Sounds.......");
	}
	
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public int getCarTopSpeed() {
		return carTopSpeed;
	}
	public void setCarTopSpeed(int carTopSpeed) {
		this.carTopSpeed = carTopSpeed;
	}
	
	//Step 2. -> Buat SubClass (Minibus, Sportcar, dll(Jika ingin))
	// Buka Class Sportcar terlebih dahulu.
	
}
