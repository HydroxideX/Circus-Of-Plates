package eg.edu.alexu.csd.oop.ClassesImplemented.Shelfs;

import eg.edu.alexu.csd.oop.ClassesImplemented.Utils.Loader;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.image.BufferedImage;

public class Shelf implements GameObject {
    private int x ,y , width , height ;
    private BufferedImage[] img =new BufferedImage[1];
    private Loader loader ;
    private Boolean isvisible ;
    public Shelf (int x,int y){
        loader = Loader.getInstance();
        img[0] = loader.getImage("Resources\\Shelfs\\shelf.png",1);
        this.width = img[0].getWidth();
        this.height = img[0] .getHeight();
        this.x= x ;
        this.y = y ;
        this.isvisible  = true;
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
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public boolean isVisible() {
        return isvisible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return img;
    }
}
