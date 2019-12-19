package Models.Plates;

import Models.Stick.Observer;
import Models.States.IState;
import View.game.GameObject;

import java.awt.image.BufferedImage;

public class Plate implements GameObject, Observer, Cloneable {

    private BufferedImage[] spriteImages = new BufferedImage[1];
    private int x, y, width = 100, height = 100;
    public boolean isVisible = true;
    public String color = "";
    private String type = "1";
    private IState state;
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
    public boolean update (int diff){
        state.Update(diff);
        return true;
    }
    public int getYError(){
        return 0;
    }

    public Object clone() throws
            CloneNotSupportedException
    {
        return super.clone();
    }
}
