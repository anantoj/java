package latihanUAP;

import java.util.Random;

public class Coffee extends Drink {

    private int sugar;
    
    public Coffee(String name, String size, int sugar) {
        setName(name);
        setSize(size);
        setSugar(sugar);
        setPrice(calculatePrice());
        generateId();
    }

    @Override
    public int calculatePrice() {
        // TODO Auto-generated method stub
        int price = 12000;

        switch (getSize()) {
            case "Small":
                price += 5000;
                break;
            case "Medium":
                price += 10000;
                break;
            case "Large":
                price += 15000;
                break;
        }
        price += sugar * 1000;

        return price;
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.printf("| %5s | %-15s | %-10s | %-5d | %-12s | %-10d |\n",
                getId(),
                getName(),
                getSize(),
                getSugar(),
                "-", // Topping
                getPrice()
                );
    }

    @Override
    public void generateId() {
        // TODO Auto-generated method stub
        Random rand = new Random();
        String id = String.format("CF%03d", rand.nextInt(1000));
        setId(id);
    }

    @Override
    public String getOrder() {
        // TODO Auto-generated method stub
        // Small Americano Coffee with 0 Sugar is sold
        return getSize() + " " + getName() + " Coffee with " + getSugar() + " Sugar is sold!";
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }
    
}
