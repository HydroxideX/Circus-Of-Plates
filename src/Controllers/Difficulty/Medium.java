package Controllers.Difficulty;

import Models.Plates.SpecialPlate;

public class Medium implements Speed {
    public int controlspeed ;
    public int speed ;

    public Medium(){
        controlspeed = 25;
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
