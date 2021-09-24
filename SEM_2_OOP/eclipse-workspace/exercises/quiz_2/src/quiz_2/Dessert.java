package quiz_2;

public class Dessert extends Item implements Runnable{
    private String topping;
    private double calories;

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

    public Dessert(String name, int price, int time, String topping, double calories) {
        setName(name);
        setPrice(price);
        setTime(time);
        this.topping = topping;
        this.calories = calories;
    }

    @Override
    public void run() {
        int total_time = getTime();
        try {
			do {
				Thread.sleep(1000);

                total_time -= 1;
                setTime(total_time);
			} while (total_time > 0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}