package Models.Plates;

import View.game.GameObject;

public class Pot extends Plate implements GameObject {
    public String getType(){
        return "Pot";
    }
    public int getYError(){
        return 31;
    }
}
