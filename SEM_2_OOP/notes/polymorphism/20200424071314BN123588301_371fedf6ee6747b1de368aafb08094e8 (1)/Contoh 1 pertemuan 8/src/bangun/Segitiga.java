package bangun;

public class Segitiga extends BangunDatar{
	int alas;
	int tinggi;
	
	public Segitiga(int a, int t) {
		this.alas = a;
		this.tinggi = t;
	}
	
	@Override
	public float luas() {
		return (this.alas * this.tinggi)/2;
	}
}
