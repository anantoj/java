//Membuat thread dengan 'Extends Thread'
public abstract class Person extends Thread{
	private String helper_name;
	private int work_time;
	private int remaining_time;
	
	public String getHelper_name() {
		return helper_name;
	}
	public void setHelper_name(String helper_name) {
		this.helper_name = helper_name;
	}
	public int getWork_time() {
		return work_time;
	}
	public void setWork_time(int work_time) {
		this.work_time = work_time;
	}
	public int getRemaining_time() {
		return remaining_time;
	}
	public void setRemaining_time(int remaining_time) {
		this.remaining_time = remaining_time;
	}
	
	public abstract void run();
	
}
