package employee_data;

public class Employee {
    private boolean isActive;
    private String name;
    private int age;
    private String role;

    public void setIsActive(boolean isActive ){
        this.isActive = isActive;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setRole(String role){
        this.role = role;
    }

    public boolean getIsActive(){
        return isActive;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getRole(){
        return role;
    }

    public Employee(String name, int age, String role){
        this.isActive = true;
        this.name = name;
        this.age = age;
        this.role = role;
    }
}
