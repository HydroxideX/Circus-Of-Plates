package eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.image.BufferedImage;

public class Pot extends Plate implements GameObject {
    /*public Pot(int x, int y, int height, int width, String color, BufferedImage img) {
        super(x, y, height, width, color, img);
    }*/public String getType(){
        return "Pot";
    }
}
