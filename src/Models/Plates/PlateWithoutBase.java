package Models.Plates;

import View.game.GameObject;

public class PlateWithoutBase extends Plate implements GameObject {
   public String getType(){
       return "PlateWithoutBase";
   }
    public int getYError(){
        return -10;
    }
}
