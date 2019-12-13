package eg.edu.alexu.csd.oop.ClassesImplemented.Shapes.Plates;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.image.BufferedImage;

public class Shape implements GameObject {

    private BufferedImage[] spriteImages;
    private int x, y, width, height;
    public boolean isVisible;
    private String color ;
    public Shape (int x , int y , int height , int width,String color,BufferedImage img){
        this.spriteImages[0] = img;
        this.setX(x);
        this.setY(y);
        this.width = width;
        this.height = height;
        this.color = color;
    }
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
        return new BufferedImage[0];
    }
    public String getColor (){
        return this.color;
    }
}
