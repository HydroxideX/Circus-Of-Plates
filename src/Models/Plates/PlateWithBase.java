package Models.Plates;

import View.game.GameObject;

public class PlateWithBase extends Plate implements GameObject{
    public String getType(){
        return "PlateWithBase";
    }
    public int getYError(){
        return -9;
    }
}
