package abstractClass;

public class Limo extends Taxi{
	public Limo(){
		setTD(25000);
		setTP(4000);
	}
	public int hitungBiaya(int km){
		int biaya = getTD() + ((km/2) * getTP());
		return biaya;
	}
}