package eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates;

import eg.edu.alexu.csd.oop.game.GameObject;

public class SpecialPlate extends Plate implements GameObject,ISpecial {
    public String getType(){
        return "SpecialPlate";
    }
}
