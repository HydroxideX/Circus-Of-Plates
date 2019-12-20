package Controllers.Difficulty;

public class Easy implements Speed{
    public int controlspeed ;
    public int speed ;
    public Easy(){
        controlspeed = 30;
        speed = 10;
    }
    @Override
    public int getSpeed() {
        return 10;
    }
    @Override
    public int getControlSpeed() {
        return controlspeed;
    }
}
