package Controllers.Difficulty;

import Models.Plates.SpecialPlate;

public class Hard extends Speed {
    public Hard(){
        controlspeed = 20;
    }
    public int getSpeed() {
        return 5;
    }

    public int getControlSpeed() {

        return controlspeed;
    }
}
