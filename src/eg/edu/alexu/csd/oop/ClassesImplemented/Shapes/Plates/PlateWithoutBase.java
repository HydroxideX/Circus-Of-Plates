package eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.image.BufferedImage;

public class PlateWithoutBase extends Plate implements GameObject {
   public String getType(){
       return "PlateWithoutBase";
   }
    public int getYError(){
        return 13;
    }
}
