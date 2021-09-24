package latihanUAP;

import java.util.Random;

public class MilkTea extends Drink {

    private String topping;

    public MilkTea(String name, String size, String topping) {
        setName(name);
        setSize(size);
        setTopping(topping);
        setPrice(calculatePrice());
        generateId();
    }
    @Override
    public int calculatePrice() {
        // TODO Auto-generated method stub
        int price = 20000;

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

        switch (getTopping()) {
            case "Boba":
                price += 3000;
                break;
            case "Grass Jelly":
            price += 5000;
                break;
        }

        return price;
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.printf("| %5s | %-15s | %-10s | %-5s | %-12s | %-10d |\n",
                getId(),
                getName(),
                getSize(),
                "-", // Topping
                getTopping(),
                getPrice()
                );
    }

    @Override
    public void generateId() {
        // TODO Auto-generated method stub
        Random rand = new Random();
        String id = String.format("MF%03d", rand.nextInt(1000));
        setId(id);
    }

    @Override
    public String getOrder() {
        // TODO Auto-generated method stub
        return getSize() + " " + getName() + " Milk Tea with " +getTopping() + " Topping is sold!";
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
 
}
