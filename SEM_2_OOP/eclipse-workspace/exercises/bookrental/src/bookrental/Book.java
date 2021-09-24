package bookrental;

public class Book {
	protected String title;
	protected int price;
	protected int quantity;
	
	public void setName(String title){
		this.title = title;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Book(String title, int price, int quantity) {
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
}
