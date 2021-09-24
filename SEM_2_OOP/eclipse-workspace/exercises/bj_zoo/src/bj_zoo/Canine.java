package bj_zoo;

public class Canine extends Animal{
    private int speed;

    public Canine(String name, String gender, int speed){
        super(name, gender);
        this.speed = speed;
    }

    @Override
    public void sound1() {
        // TODO Auto-generated method stub
        System.out.println("ruff ruff <3");
    }

    @Override
    public void sound2() {
        // TODO Auto-generated method stub
        System.out.println("awooo!");
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public int getSpeed(){
        return speed;
    }
}
