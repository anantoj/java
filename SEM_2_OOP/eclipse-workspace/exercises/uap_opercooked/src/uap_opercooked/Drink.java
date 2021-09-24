package uap_opercooked;

import java.util.Random;

public class Drink extends MenuItem{
	private String flavor;
	private String size;

	public Drink(String name, int price, String flavor, String size) {
		setName(name);
		setPrice(price);
		this.flavor = flavor;
		this.size = size;
		int extraTime = 0;
		if (flavor.equals("Mint")){
			extraTime = 10;
		}
		else if (flavor.equals("Mix Berry")){
			extraTime = 20;
		}
		else{
			extraTime = 30;
		}
		setCookingTime(calculateCookingTime(extraTime));
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public int calculateCookingTime(int extraTime) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		return rand.nextInt(41) + 10 + extraTime;

	}

	
}

