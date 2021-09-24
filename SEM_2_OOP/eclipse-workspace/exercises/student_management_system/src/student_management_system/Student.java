package student_management_system;

public class Student {
	private String nim;
	private String name;
	private String phone;
	
	public void setNim(String nim) {
		this.nim = nim;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNim() {
		return this.nim;
	}
	public String getName() {
		return this.name;
	}
	public String getPhone() {
		return this.phone;
	}
	
	public Student(String nim, String name, String phone) {
		this.nim = nim;
		this.name = name;
		this.phone = phone;
	}
}
