package bookrental;

public class TotalPrice {
	protected int total;
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getTotal() {
		return total;
	}
	
	public TotalPrice(int total) {
		this.total = total;
	}
	
	public void incrementTotal(int total){
		this.total += total;
	}
}
