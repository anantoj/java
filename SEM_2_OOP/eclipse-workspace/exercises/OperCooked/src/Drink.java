
public class Drink {
	private String flavor;
	private char size;

	public Drink() {
		// TODO Auto-generated constructor stub
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	@Override
	public int calculateCookingTime() {
		return 0;
	}

	
}
