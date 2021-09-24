import java.util.Random;

public class Scientist extends Person{

	public Scientist(String helper_name, int work_time) {
		setHelper_name("Professor "+helper_name);
		setWork_time(work_time);
		setRemaining_time(work_time*1000);
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(getRemaining_time() >= 0){
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setRemaining_time(getRemaining_time()-100);
		}
		
		Random rand = new Random();
		int add = rand.nextInt(getWork_time()/5);
		
		if(add == 0) add = 1;
		Main.virus -= (getWork_time()/10);
		Main.patient += add;
	}
	
}
