package Controllers.Difficulty;

import Models.Plates.SpecialPlate;

public class Medium extends Speed {
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
