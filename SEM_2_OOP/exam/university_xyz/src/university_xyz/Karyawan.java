package university_xyz;

import java.util.Calendar;

public abstract class Karyawan extends Orang {
    private String location;
    private int salary;
    private Calendar date;

    public abstract String printDate();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    
}
