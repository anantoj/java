package bj_zoo;

public class Feline extends Animal{
    
    public Feline(String name, String gender){
        super(name, gender);
    }

    @Override
    public void sound1() {
        // TODO Auto-generated method stub
        System.out.println("meow meow <3");
    }

    @Override
    public void sound2() {
        // TODO Auto-generated method stub
        System.out.println("hiss!");
    }
}
