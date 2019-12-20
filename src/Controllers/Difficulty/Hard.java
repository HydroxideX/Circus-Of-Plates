package Controllers.Difficulty;

import Models.Plates.SpecialPlate;

public class Hard implements Speed {
    public int controlspeed ;
    public int speed ;
    public Hard(){
        controlspeed = 20;
        speed  = 5;
    }

    @Override
    public int getSpeed() {
        return 5;
    }

    @Override
    public int getControlSpeed() {

        return controlspeed;
    }
}
