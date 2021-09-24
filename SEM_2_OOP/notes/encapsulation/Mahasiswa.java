package pert_5;

public class Mahasiswa {
	//attribute
	private String nama;
	private String nim;
	
	// 4 method dibawah ini untuk Getter Setter
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	
	//constructor
	public Mahasiswa(String nama , String nim) {
		this.nama = nama;
		this.nim = nim;
	}
	
	//method yang dibuat sendiri dalam class
	public void printIdentitas(){
		System.out.println(nama + " / " + nim );
	}

}
