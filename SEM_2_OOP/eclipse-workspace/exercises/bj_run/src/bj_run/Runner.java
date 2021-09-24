package bj_run;

public abstract class Runner{
    private String name;
    private int runSpeed;
    private int distance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunSpeed() {
        return runSpeed;
    }

    public void setRunSpeed(int runSpeed) {
        this.runSpeed = runSpeed;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public abstract void move();
}
