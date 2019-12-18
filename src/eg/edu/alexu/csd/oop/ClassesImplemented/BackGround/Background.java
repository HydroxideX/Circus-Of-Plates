package eg.edu.alexu.csd.oop.ClassesImplemented.BackGround;

import eg.edu.alexu.csd.oop.ClassesImplemented.Utils.Loader;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Background implements GameObject, Serializable {
    public int x = 0,y = 0,width = 0,height = 0;
    public BufferedImage[] spriteImages = new BufferedImage[1];

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int p0) {
        x = p0;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int p0) {
        y = p0;
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
        return true;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }
}
