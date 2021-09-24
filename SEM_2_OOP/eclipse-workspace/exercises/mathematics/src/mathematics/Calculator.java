package mathematics;

public class Calculator implements Operation<Integer> {

	@Override
	public Integer add(Integer a, Integer b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public Integer subtract(Integer a, Integer b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public Integer multiply(Integer a, Integer b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public Integer divide(Integer a, Integer b) {
		// TODO Auto-generated method stub
		return a / b;
	}
    
}
