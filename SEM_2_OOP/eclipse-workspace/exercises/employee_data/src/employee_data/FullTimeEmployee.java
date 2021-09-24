package employee_data;

public class FullTimeEmployee extends Employee{
    private int salary;

    public FullTimeEmployee(String name, int age, String role, int salary){
        super(name, age, role);
        this.salary = salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

}
