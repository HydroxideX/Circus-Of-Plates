package Models.Plates;

import View.game.GameObject;

public class PlateWithDeepBase extends Plate implements GameObject {
    public String getType(){
        return "PlateWithDeepBase";
    }
    public int getYError(){
        return 20;
    }
}
