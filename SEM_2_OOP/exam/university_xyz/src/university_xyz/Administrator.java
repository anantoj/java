package university_xyz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Administrator extends Karyawan {
    private String title;

    public Administrator(String name, String address, String phone, String email, String location, int salary, Calendar date ,String title){
        setName(name);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setLocation(location);
        setSalary(salary);
        setDate(date);
        setTitle(title);
    }

    @Override
    public String toString(){
        return  "Adminstrator " + getName();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String printDate() {
        Date d = getDate().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        return dateFormat.format(d);
    }
}
