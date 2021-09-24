package even_odd;

public abstract class Numbers implements Runnable{
	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public abstract void run();

}
