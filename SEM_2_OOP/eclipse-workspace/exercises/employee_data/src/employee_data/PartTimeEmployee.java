package employee_data;

public class PartTimeEmployee extends Employee{
    private int payHour;
    private int workHour;
    
    public PartTimeEmployee(String name, int age, String role, int payHour, int workHour){
        super(name, age, role);
        this.payHour = payHour;
        this.workHour = workHour;
    }

    public void setPayHour(int payHour){
        this.payHour = payHour;
    }

    public void setWorkHour(int workHour){
        this.workHour = workHour;
    }

    public int getPayHour(){
        return payHour;
    }

    public int getWorkHour(){
        return workHour;
    }
}
