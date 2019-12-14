package eg.edu.alexu.csd.oop.ClassesImplemented.Clowns;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import eg.edu.alexu.csd.oop.game.GameObject;
import net.coobird.thumbnailator.Thumbnails;

public class ImageObject implements GameObject {
    BufferedImage[] spriteImages = new BufferedImage[1];
    int x;
    private int y;
    private boolean visible;
    private int type;

    public ImageObject (int posX, int posY, String path) {
        this(posX, posY, path, 0);
    }

    public ImageObject (int posX, int posY, String path, int type) {
        this.x = posX;
        this.y = posY;
        this.type = type;
        this.visible = true;
        try {
            spriteImages[0] = ImageIO.read(new File(path));
            spriteImages[0] = Thumbnails.of(spriteImages[0]).scale(0.1).asBufferedImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int mX) {
        this.x = mX;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int mY) {
        this.y = mY;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }



    @Override
    public int getWidth(){
        return spriteImages[0].getWidth() + 100;
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight() + 100;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
