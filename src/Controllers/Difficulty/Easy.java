package Controllers.Difficulty;

public class Easy extends Speed{

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
