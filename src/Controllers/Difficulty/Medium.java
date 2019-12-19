package Controllers.Difficulty;

import Models.Plates.SpecialPlate;

public class Medium extends Speed {
    public Medium(){
        controlspeed = 25;
    }
    public int getSpeed() {
        return 10;
    }

    public int getControlSpeed() {

        return controlspeed;
    }
}
