package quiz_2;

public class History {
    private String name;
    private int price;
    private String topping;
    private String calories;
    private String flavor;
    private String size;
    private String orderTime;

    public String getName() {
        return name;
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

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
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

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public History(String name, int price, String topping, String calories, String flavor, String size, String orderTime) {
        this.name = name;
        this.price = price;
        this.topping = topping;
        this.calories = calories;
        this.flavor = flavor;
        this.size = size;
        this.orderTime = orderTime;
    }
}
