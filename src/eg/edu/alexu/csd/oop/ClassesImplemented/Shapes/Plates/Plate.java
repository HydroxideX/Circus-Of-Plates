package eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates;

import eg.edu.alexu.csd.oop.ClassesImplemented.States.IState;
import eg.edu.alexu.csd.oop.game.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Plate implements GameObject {

    private BufferedImage[] spriteImages = new BufferedImage[1];
    private int x, y, width = 100, height = 100;
    public boolean isVisible = true;
    public String color = "";
    private String type = "1";
    private IState state ;
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int p0) {
        this.x = p0;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int p0) {
        this.y = p0;

    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    public void setSpriteImages(BufferedImage img) {
        this.spriteImages[0] = img;
        this.height = img.getHeight();
        this.width = img.getWidth();
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return "NormalPlate";
    }
    public void setState(IState state){
        this.state = state;
    }
    public void update (int diff){
        state.Update(diff);
    }
}
