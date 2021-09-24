package even_odd;

public class Odd extends Numbers{

	public Odd(int number) {
		// TODO Auto-generated constructor stub
		setNumber(number);
	}

	@Override
	public void run(){
		int odd = 1;
		for (int i = 0; i < getNumber(); i++){
			System.out.println("odd number: " + odd);
			odd += 2;
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				//TODO: handle exception
			}
		}
	}

}
