package Models.Plates;

import View.game.GameObject;

public class SpecialPlate extends Plate implements GameObject,ISpecial {
    public String getType(){
        return "SpecialPlate";
    }
}
