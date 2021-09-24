package even_odd;

public class Even extends Numbers {

	public Even(int number) {
		// TODO Auto-generated constructor stub
		setNumber(number);
	}

	@Override
	public void run() {
		int even = 0;
		for (int i = 0; i < getNumber(); i++){
			System.out.println("Even number: " + even);
			even += 2;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				//TODO: handle exception
			}
		}
	}

}
