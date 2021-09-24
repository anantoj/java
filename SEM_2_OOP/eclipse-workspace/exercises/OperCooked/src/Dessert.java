
public class Dessert extends MenuItem {
	private String topping;
	private double calories;

	public Dessert(String name, int price, String topping, double calories) {
		setName(name);
		setPrice(price);
		this.topping = topping;
		this.calories = calories;
		setCookingTime(calculateCookingTime());
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
	public int calculateCookingTime() {
		return 0;
	}

	

	

}
