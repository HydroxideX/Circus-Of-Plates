package Controllers.Difficulty;

public class Easy extends Speed{

    public Easy(){
        controlspeed = 30;
    }
    public int getSpeed() {
        return 10;
    }

    public int getControlSpeed() {
        return controlspeed;
    }
}
