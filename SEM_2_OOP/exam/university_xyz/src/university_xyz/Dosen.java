package university_xyz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dosen extends Karyawan {
    private int hours;
    private String level;

    public Dosen(String name, String address, String phone, String email, String location, int salary, Calendar date,
            int hours, String level) {
        setName(name);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setLocation(location);
        setSalary(salary);
        setDate(date);
        setHours(hours);
        setLevel(level);
    }

    @Override
    public String toString() {
        return "Dosen " + getName();
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String printDate() {
        Date d = getDate().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        return dateFormat.format(d);
    }

    
}
