package bj_run;

import java.util.Random;

public class Turtle extends Runner {

    public Turtle(String name, int runSpeed) {
        setName(name);
        setRunSpeed(runSpeed);
    }
    
    public void move(){
        Random rand = new Random();
        int boost = 0;
        int specialMove = rand.nextInt(10);
        if (specialMove > 7) {
            boost = 15;
        }
        int mv = rand.nextInt(getRunSpeed()) + rand.nextInt(10) + boost;
        setDistance(getDistance() + mv);
    }
}
