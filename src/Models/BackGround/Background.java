package Models.BackGround;

import Models.Logger.GameLogger;
import View.game.GameObject;

import java.awt.image.BufferedImage;

public class Background implements GameObject,Cloneable {
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


    public Object clone()
    {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            GameLogger logger = GameLogger.getInstance();
            logger.addLog("severe", "Not Cloneable Object Created");
        }
        return null;
    }
}
