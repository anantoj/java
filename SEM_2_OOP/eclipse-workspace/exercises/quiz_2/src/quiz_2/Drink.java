package quiz_2;

public class Drink extends Item implements Runnable{
    private String flavor;
    private String size;

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

    public Drink(String name, int price, int time, String flavor, String size) {
        setName(name);
        setPrice(price);
        setTime(time);
        this.flavor = flavor;
        this.size = size;
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
