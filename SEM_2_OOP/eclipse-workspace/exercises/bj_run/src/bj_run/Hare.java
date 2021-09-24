package bj_run;

import java.util.Random;

public class Hare extends Runner {

    public Hare(String name, int runSpeed) {
        setName(name);
        setRunSpeed(runSpeed);
    }
    
    public void move() {
        Random rand = new Random();
        int mv = rand.nextInt(getRunSpeed());
        setDistance(getDistance() + mv);
    }
}
