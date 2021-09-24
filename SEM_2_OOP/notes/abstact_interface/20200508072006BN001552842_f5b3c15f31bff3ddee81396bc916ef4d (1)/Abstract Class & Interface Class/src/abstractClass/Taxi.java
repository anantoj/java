package abstractClass;


abstract class Taxi{
	private int TD;
	private int TP;
	//setter
	public void setTD(int td){
		TD = td;
	}
	public void setTP(int tp){
		TP = tp;
	}
	
	//getter
	public int getTD(){
		return TD;
	}
	public int getTP(){
		return TP;
	}
	
	public abstract int hitungBiaya(int km);
	
}
