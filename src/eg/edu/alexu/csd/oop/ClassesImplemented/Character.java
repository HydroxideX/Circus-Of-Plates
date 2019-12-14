package eg.edu.alexu.csd.oop.ClassesImplemented;

import eg.edu.alexu.csd.oop.game.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Character implements GameObject {
    private BufferedImage[] spriteImages;
    private int x, y, width, height;
    private boolean isVisible;


    public Character(){
        spriteImages = new BufferedImage[1];
        {
            try {
                spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("Resources/images.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        x = 100;
        y = 100;
        width = spriteImages[0].getWidth();
        height = spriteImages[0].getHeight();
        isVisible = true;
    }



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
        return isVisible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }
}
