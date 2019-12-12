package eg.edu.alexu.csd.oop.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Character extends ControlableObject implements GameObject {

    private BufferedImage[] spriteImages;
    {
        try {
            spriteImages = new BufferedImage[]{ImageIO.read(getClass().getResourceAsStream("Resources/yahia.jpg"))};
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private int x, y, width = spriteImages[0].getWidth(), height = spriteImages[0].getHeight();
    private boolean isVisible = false;

    public Character(GameObject gameObject) {
        super(gameObject);
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
