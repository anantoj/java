package bj_zoo;

public class Animal {
	private String name;
	private String gender;
	private boolean isHappy;
	private int roamTime;
	
	public Animal(String name, String gender) {
		this.name = name;
		this.gender = gender;
		isHappy = true;
	}

	public void sound1(){
		System.out.println("sound 1");
	}
	public void sound2(){
		System.out.println("sound 2");
	}

	public void setName(String name){
		this.name = name;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public String getName(){
		return name;
	}
	public String getGender(){
		return gender;
	}
	public void setIsHappy(boolean isHappy){
		this.isHappy = isHappy;
	}
	public boolean getIsHappy(){
		return isHappy;
	}
	public void setRoamTime(int roamTime){
		this.roamTime = roamTime;
	}
	public int getRoamTime(){
		return roamTime;
	}

	

}
