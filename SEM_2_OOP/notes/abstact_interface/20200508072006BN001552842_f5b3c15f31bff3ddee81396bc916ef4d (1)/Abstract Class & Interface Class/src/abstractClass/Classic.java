package abstractClass;

class Classic extends Taxi{
	public Classic(){
		setTD(3000);
		setTP(350);
	}
	
	//overriding method
	public int hitungBiaya(int km){
		int biaya = getTD() + ((km/2) * getTP());
		int diskon = (km/100) * 1000;
		return biaya - diskon;
	}
}