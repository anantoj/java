package university_xyz;

public class Mahasiswa extends Orang{
    private int year;

    public Mahasiswa(String name, String address, String phone, String email, int year){
        setName(name);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setYear(year);
    }
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString(){
        return  "Mahasiswa " + getName();
    }

}
