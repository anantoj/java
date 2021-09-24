
//Gunakan final class apabila class sudah fix dan tidak bisa di extends
public final class Donut {
	private String name;
	private String filling;
	private int price;
	public Donut(String name, String filling, int price) {
		super();
		this.name = name;
		this.filling = filling;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilling() {
		return filling;
	}
	public void setFilling(String filling) {
		this.filling = filling;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
