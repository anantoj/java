package uap_opercooked;

import java.util.Random;

public class Dessert extends MenuItem {
	private String topping;
	private double calories;

	public Dessert(String name, int price, String topping, double calories) {
		setName(name);
		setPrice(price);
		this.topping = topping;
		this.calories = calories;
		int extraTime = 0;
		if (topping.equalsIgnoreCase("Caramel")) {
			extraTime = 10;
		} else if (topping.equalsIgnoreCase("Honey")) {
			extraTime = 15;
		} else {
			extraTime = 20;
		}
		setCookingTime(calculateCookingTime(extraTime));
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	@Override
	public int calculateCookingTime(int extraTime) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		return rand.nextInt(41) + 50 + extraTime;

	}

	



}