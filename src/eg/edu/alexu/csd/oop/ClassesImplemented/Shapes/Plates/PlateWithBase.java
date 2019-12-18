package eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.image.BufferedImage;

public class PlateWithBase extends Plate implements GameObject{
    public String getType(){
        return "PlateWithBase";
    }
    public int getYError(){
        return -9;
    }
}
