package uap_opercooked;

public abstract class MenuItem implements Runnable {
	private String name;
	private int price;
	private int cookingTime;
	private String timeString;

	public String getName() {
		return name;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int time = getCookingTime();

		while (time > 0) {
			time--;
			setCookingTime(getCookingTime()-1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}
		}
	}

	public abstract int calculateCookingTime(int extraTime);
}
