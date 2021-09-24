
//Inheritance -> menggunakan keyword extends
public class MilkTea extends Tea{

	private String topping;

	public String getTopping() {
		return topping;
	}
	public void setTopping(String topping) {
		this.topping = topping;
	}
	
	public MilkTea(String name, int price, String topping) {
		//super() --> digunakan untuk memanggil constructor super class
		super(name, price);
		this.topping = topping;
		setNewPrice();
		setNewName();
	}
	
	private void setNewPrice(){
		//Method setPrice tidak ada, tetapi bisa diakses karena MilkTea extends dari Tea
		//Selama access modifier tidak private, method/atribut bisa diakses
		if(topping.equals("Boba")) setPrice(getPrice()+5000);
		else if(topping.equals("Grass Jelly")) setPrice(getPrice()+7000);
		else if(topping.equals("Red Bean")) setPrice(getPrice()+9000);
	}
	
	private void setNewName(){
		setName(getName()+" with "+topping);
	}
}
